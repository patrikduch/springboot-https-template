package com.patrikduch.springboot_https_template.core.interfaces;

/**
 * @interface PortConfig Config contract for accessing Http/Https port configuration.
 * @author Patrik Duch
 */
public interface PortConfig {
    int getHttpPort() throws Exception;
    int getHttpsPort() throws  Exception;
}
