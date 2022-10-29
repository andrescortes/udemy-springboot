package com.springsimplespasos.conceptosbasicos.useyaml;

import java.util.List;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("server")
@PropertySource(value = "classpath:server.yml", factory = YamlPropertySourceFactory.class)
public class ReadYaml {

    private Map<String, String> application;

    private Map<String, List<String>> configuration;

    private Map<String, User> users;

    public Map<String, String> getApplication() {
        return application;
    }

    public void setApplication(Map<String, String> application) {
        this.application = application;
    }

    public Map<String, List<String>> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(
        Map<String, List<String>> configuration) {
        this.configuration = configuration;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(
        Map<String, User> users) {
        this.users = users;
    }
}
