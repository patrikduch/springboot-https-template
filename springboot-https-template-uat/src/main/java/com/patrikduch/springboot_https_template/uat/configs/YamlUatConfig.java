package com.patrikduch.springboot_https_template.uat.configs;

import com.patrikduch.springboot_https_template.core.interfaces.YamlConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Access to the external YAML config file.
 * @author Patrik Duch
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix="uat")
@Profile("uat")
public class YamlUatConfig implements YamlConfig {

}
