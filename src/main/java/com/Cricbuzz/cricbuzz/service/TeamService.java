package com.Cricbuzz.cricbuzz.service;

import com.Cricbuzz.cricbuzz.convertor.TeamConvertor;
import com.Cricbuzz.cricbuzz.dto.request.TeamRequest;
import com.Cricbuzz.cricbuzz.dto.response.TeamResponse;
import com.Cricbuzz.cricbuzz.model.Team;
import com.Cricbuzz.cricbuzz.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    public TeamResponse addTeam(TeamRequest teamRequest) {
        Team team = TeamConvertor.teamRequestToTeam(teamRequest);
        Team savedTeam = teamRepository.save(team);
        return TeamConvertor.teamToTeamResponse(savedTeam);
    }
}