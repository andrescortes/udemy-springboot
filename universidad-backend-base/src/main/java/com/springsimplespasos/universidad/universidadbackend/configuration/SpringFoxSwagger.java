package com.springsimplespasos.universidad.universidadbackend.configuration;

import java.util.Collection;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxSwagger {

    @Bean
    public Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()//instance apiSelectorBuilder, entry points to the API
            .apis(
                RequestHandlerSelectors.basePackage(
                    "com.springsimplespasos.universidad.universidadbackend.controller.dto"))//select the packages to scan for annotated controllers
            .paths(PathSelectors.any())//select the paths to scan for annotated controllers
            .build()
            .apiInfo(apiInfo());//add the api info to the Docket instance

    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
            "University Backend Api",
            "API to University",
            "V2",
            "Terms of Service and Conditions",
            new Contact("Miguel Cortes", "www.google.com", "andresabyac@gmail.com"),
            "License of API", "API license URL", Collections.emptyList()
        );
    }
}
