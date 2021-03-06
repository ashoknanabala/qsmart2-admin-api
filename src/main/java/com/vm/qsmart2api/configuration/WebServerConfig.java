/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.qsmart2api.configuration;

import org.eclipse.jetty.http.HttpVersion;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.SecureRequestCustomizer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.SslConnectionFactory;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.jetty.JettyServerCustomizer;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Phani
 */
@Configuration
public class WebServerConfig {
    
    @Value("${server.http.port}")
    private int httpPort;
    
    @Value("${server.port}")
    private int httpsPort;
    
    
    @Value("${server.ssl.key-store}")
    private String keyStorePath;
    
    @Value("${server.ssl.key-store-password}")
    private String keyStorePwd;
    
    @Bean
    public WebServerFactoryCustomizer<JettyServletWebServerFactory> webServerFactoryCustomizer() {
        
        return new WebServerFactoryCustomizer<JettyServletWebServerFactory>() {
            
            @Override
            public void customize(JettyServletWebServerFactory factory) {
                
                factory.addServerCustomizers(new JettyServerCustomizer() {
                    
                    @Override
                    public void customize(Server server) {
                        
                        ServerConnector httpConnector = new ServerConnector(server);
                        httpConnector.setPort(httpPort);
                        
                        SslContextFactory sslContextFactory = new SslContextFactory("");
                        try {
                            sslContextFactory
                                    .setKeyStorePath(keyStorePath);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        
                        sslContextFactory.setKeyStorePassword(keyStorePwd);
                        sslContextFactory.setKeyStoreType("PKCS12");
                        
                        HttpConfiguration httpsConfiguration = new HttpConfiguration();
                        httpsConfiguration.addCustomizer(new SecureRequestCustomizer());
                        
                        ServerConnector httpsConnector = new ServerConnector(server,
                                new SslConnectionFactory(sslContextFactory, HttpVersion.HTTP_1_1.asString()),
                                new HttpConnectionFactory(httpsConfiguration));
                        httpsConnector.setPort(httpsPort);
                        
                        server.setConnectors(new Connector[]{httpConnector, httpsConnector});
                    }
                });
                
            }
        };
    }
}
