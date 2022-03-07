package com.patrikduch.springboot_https_template.core.configs;

import com.patrikduch.springboot_https_template.core.interfaces.PortConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @class PortConfig implementation for accessing global HTTP and HTTPS port configuration.
 * @author Patrik Duch
 */
@Service
public class PortConfigImpl implements PortConfig {

    @Autowired
    private Environment env;

    @Override
    public int getHttpPort() throws Exception {
        var port = Integer.parseInt(env.getProperty("http.port"));
        return port;
    }

    @Override
    public int getHttpsPort() throws Exception {
        var port = Integer.parseInt(env.getProperty("https.port"));
        return port;
    }
}
