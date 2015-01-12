#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${rootArtifactId};


import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import ${package}.${rootArtifactId}.conf.HelloWorldConfiguration;
import ${package}.${rootArtifactId}.health.TemplateHealthCheck;
import ${package}.${rootArtifactId}.resource.HelloWorldResource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pnajda
 */
public class HelloWorldService extends Service<HelloWorldConfiguration> {
    
    public static void main(String args[]) throws Exception {
        new HelloWorldService().run(args);        
    }
    
    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.setName("hello-world");
    }
    
    @Override
    public void run(HelloWorldConfiguration configuration,
                Environment environment) {
        
        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        environment.addResource(new HelloWorldResource(template, defaultName));
        environment.addHealthCheck(new TemplateHealthCheck(template));

    }
    
}
