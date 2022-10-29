package com.springsimplespasos.conceptosbasicos.dependencyinjection.service;

import com.springsimplespasos.conceptosbasicos.dependencyinjection.domain.Team;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
@Component(value = "team-arg")
@ConditionalOnProperty(prefix = "app", name= "implementation", havingValue = "argentina")
public class TeamServiceArgImpl implements TeamService {

    private List<Team> teams = new ArrayList<>(Arrays.asList(
        new Team(1, "Boca Juniors", 1901, LocalDate.of(1901, 8, 25)),
        new Team(2, "Velez", 1905, LocalDate.of(1905, 6, 20)),
        new Team(3, "River Plate", 1910, LocalDate.of(1910, 9, 28))
    ));

    @Override
    public Optional<Team> getTeamById(Integer id) {
        return Optional.empty();
    }

    @Override
    public Iterable<Team> getAllTeams() {
        return teams;
    }
}
