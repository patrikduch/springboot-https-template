package com.patrikduch.springboot_https_template.domain.dtos;

import lombok.Getter;
import lombok.Setter;

/**
 * @class TestDto  Test DTO for test REST endpoint.
 * @author Patrik Duch
 */
@Getter
@Setter
public class TestDto {
    private int id;
    private String name;
}
