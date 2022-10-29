package com.springsimplespasos.conceptosbasicos.useyaml;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestYaml implements CommandLineRunner {

    private final ReadYaml readYaml;

    public TestYaml(ReadYaml readYaml) {
        this.readYaml = readYaml;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("------------------------------yaml------------------------------");
        System.out.println("server.application.name: " + readYaml.getApplication().get("name"));
        readYaml.getConfiguration().get("ips")
            .forEach(ip -> System.out.println("server.configuration.ips: " + ip));
        readYaml.getConfiguration().get("files-system")
            .forEach(file -> System.out.println("server.configuration.files-system: " + file));
        System.out.println(
            "User root username: " + readYaml.getUsers().get("root").getUsername() + ", password: "
                + readYaml.getUsers().get("root").getPassword());


    }
}
