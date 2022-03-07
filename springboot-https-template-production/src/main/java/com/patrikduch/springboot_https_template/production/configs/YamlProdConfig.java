package com.patrikduch.springboot_https_template.production.configs;

import com.patrikduch.springboot_https_template.core.interfaces.YamlConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Access to the external YAML config file for production environment properties.
 * @author Patrik Duch
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="production")
@Profile("production")
public class YamlProdConfig implements YamlConfig {


}
