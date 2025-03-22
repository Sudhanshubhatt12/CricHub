package com.Cricbuzz.cricbuzz.service;

import com.Cricbuzz.cricbuzz.convertor.TeamConvertor;
import com.Cricbuzz.cricbuzz.dto.request.TeamRequest;
import com.Cricbuzz.cricbuzz.dto.response.TeamResponse;
import com.Cricbuzz.cricbuzz.exception.TeamNotFoundException;
import com.Cricbuzz.cricbuzz.model.Team;
import com.Cricbuzz.cricbuzz.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    @Autowired
    TeamRepository teamRepository;

    // Create
    public TeamResponse addTeam(TeamRequest teamRequest) {
        Team team = TeamConvertor.teamRequestToTeam(teamRequest);
        Team savedTeam = teamRepository.save(team);
        return TeamConvertor.teamToTeamResponse(savedTeam);
    }

    // Read All
    public List<TeamResponse> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream()
                .map(TeamConvertor::teamToTeamResponse)
                .collect(Collectors.toList());
    }

    // Read One
    public TeamResponse getTeamById(int id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException("Team not found with id: " + id));
        return TeamConvertor.teamToTeamResponse(team);
    }

    // Update
    public TeamResponse updateTeam(int id, TeamRequest teamRequest) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException("Team not found with id: " + id));
        team.setName(teamRequest.getName());
        team.setRanking(teamRequest.getRanking());
        team.setIccPoints(teamRequest.getIccPoints());
        team.setCoach(teamRequest.getCoach());
        Team updatedTeam = teamRepository.save(team);
        return TeamConvertor.teamToTeamResponse(updatedTeam);
    }

    // Delete
    public void deleteTeam(int id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException("Team not found with id: " + id));
        teamRepository.delete(team);
    }
}