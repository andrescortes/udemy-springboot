package com.springsimplespasos.conceptosbasicos.useproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ReadCommonProperties {
    @Value("${app.base.url}")
    private String baseUrl;

    public String baseUrl() {
        return baseUrl;
    }
}
