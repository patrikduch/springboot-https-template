package com.patrikduch.springboot_https_template.application.controllers;

import com.patrikduch.springboot_https_template.domain.dtos.TestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @class HomeController Test REST endpoint controller.
 * @author Patrik Duch
 */
@RestController
public class HomeController {
    @GetMapping(value = "/test")
    public ResponseEntity<TestDto> getTestData() {

        var testDto = new TestDto();
        testDto.setId(1);
        testDto.setName("Test project");

        return new ResponseEntity<>(testDto, HttpStatus.OK);
    }
}
