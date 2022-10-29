package com.springsimplespasos.conceptosbasicos.useproperties;

import com.springsimplespasos.conceptosbasicos.useproperties.inheritance.ReadBarProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestProperties implements CommandLineRunner {

    private final ReadCommonProperties readCommonProperties;

    private final ReadFooProperties readFooProperties;

    private final ReadBarProperties readBarProperties;

    public TestProperties(ReadCommonProperties readCommonProperties,
        ReadFooProperties readFooProperties, ReadBarProperties readBarProperties) {
        this.readCommonProperties = readCommonProperties;
        this.readFooProperties = readFooProperties;
        this.readBarProperties = readBarProperties;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Base URL app.base.url: " + readCommonProperties.baseUrl());
        System.out.println("----------------------------------------------------------");
        System.out.println("Client URL app.foo.client: " + readFooProperties.getClientUrl());
        System.out.println("Customer URL app.foo.customer: " + readFooProperties.getCustomerUrl());
        System.out.println("----------------------------------------------------------");
        System.out.println("bar.name: " + readBarProperties.getName());
        System.out.println("app.bar.client: " + readBarProperties.getUrl().getClient());
        System.out.println("app.bar.customer: " + readBarProperties.getUrl().getCustomer());

    }
}
