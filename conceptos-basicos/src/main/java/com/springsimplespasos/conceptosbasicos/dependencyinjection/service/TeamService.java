package com.springsimplespasos.conceptosbasicos.dependencyinjection.service;

import com.springsimplespasos.conceptosbasicos.dependencyinjection.domain.Team;
import java.util.Optional;

public interface TeamService {

    Optional<Team> getTeamById(Integer id);

    Iterable<Team> getAllTeams();

}
