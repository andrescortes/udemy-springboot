package com.springsimplespasos.universidad.universidadbackend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControllerTest {

    Logger logger = LoggerFactory.getLogger(ControllerTest.class);

    @RequestMapping(value = "/test")
    public ResponseEntity<String> test() {
        logger.trace("trace log");
        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");

        return new ResponseEntity<>("Hello World", HttpStatus.ACCEPTED);

    }

}
