package com.springsimplespasos.conceptosbasicos.dependencyinjection.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TeamTest implements CommandLineRunner {

    @Autowired
    //@Qualifier("team-esp")
    TeamService teamService;

    @Override
    public void run(String... args) throws Exception {
        teamService.getAllTeams().forEach(System.out::println);
    }
}
