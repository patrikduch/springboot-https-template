package com.patrikduch.springboot_https_template.app;

import com.patrikduch.springboot_https_template.core.interfaces.PortConfig;
import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

// Scanning all necessary packages
@SpringBootApplication(scanBasePackages = {
        "com.patrikduch.springboot_https_template.app",
        "com.patrikduch.springboot_https_template.production",
        "com.patrikduch.springboot_https_template.core",
        "com.patrikduch.springboot_https_template.development",
        "com.patrikduch.springboot_https_template.domain",
        "com.patrikduch.springboot_https_template.local",
        "com.patrikduch.springboot_https_template.uat",
})
public class SpringbootHttpsTemplateApplication {

    private Integer httpPort;
    private Integer httpsPort;

    @Autowired
    private PortConfig portConfig;

    @Bean
    public ServletWebServerFactory servletContainer() {

        try {
            this.httpPort = portConfig.getHttpPort();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            this.httpsPort = portConfig.getHttpsPort();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Enable SSL Trafic
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint securityConstraint = new SecurityConstraint();
                securityConstraint.setUserConstraint("CONFIDENTIAL");
                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");
                securityConstraint.addCollection(collection);
                context.addConstraint(securityConstraint);
            }
        };

        // Add HTTP to HTTPS redirect
        tomcat.addAdditionalTomcatConnectors(httpToHttpsRedirectConnector());

        return tomcat;
    }

    /*
        We need to redirect from HTTP to HTTPS. Without SSL, this application used
        port 8082. With SSL it will use port 8443. So, any request for 8082 needs to be
        redirected to HTTPS on 8443.
    */
    private Connector httpToHttpsRedirectConnector() {
        Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
        connector.setScheme("http");
        connector.setPort(httpPort);
        connector.setSecure(false);
        connector.setRedirectPort(httpsPort);
        return connector;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHttpsTemplateApplication.class, args);
    }
}
