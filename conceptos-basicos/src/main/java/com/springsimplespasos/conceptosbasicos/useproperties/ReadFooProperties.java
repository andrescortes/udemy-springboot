package com.springsimplespasos.conceptosbasicos.useproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:foo.properties")
public class ReadFooProperties {

    @Value("${app.foo.client}")
    private String clientUrl;
    @Value("${app.foo.customer:/app-foo/customer/home}")
    private String customerUrl;

    public String getClientUrl() {
        return clientUrl;
    }

    public void setClientUrl(String clientUrl) {
        this.clientUrl = clientUrl;
    }

    public String getCustomerUrl() {
        return customerUrl;
    }

    public void setCustomerUrl(String customerUrl) {
        this.customerUrl = customerUrl;
    }
}
