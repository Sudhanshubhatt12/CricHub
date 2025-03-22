package com.Cricbuzz.cricbuzz.controller;

import com.Cricbuzz.cricbuzz.dto.request.TeamRequest;
import com.Cricbuzz.cricbuzz.dto.response.TeamResponse;
import com.Cricbuzz.cricbuzz.exception.TeamNotFoundException;
import com.Cricbuzz.cricbuzz.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    // Create
    @PostMapping
    public ResponseEntity<TeamResponse> addTeam(@RequestBody TeamRequest teamRequest) {
        TeamResponse teamResponse = teamService.addTeam(teamRequest);
        return new ResponseEntity<>(teamResponse, HttpStatus.CREATED);
    }

    // Read All
    @GetMapping
    public ResponseEntity<List<TeamResponse>> getAllTeams() {
        List<TeamResponse> teams = teamService.getAllTeams();
        return ResponseEntity.ok(teams);
    }

    // Read One
    @GetMapping("/{id}")
    public ResponseEntity<TeamResponse> getTeamById(@PathVariable int id) {
        try {
            TeamResponse teamResponse = teamService.getTeamById(id);
            return ResponseEntity.ok(teamResponse);
        } catch (TeamNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<TeamResponse> updateTeam(
            @PathVariable int id,
            @RequestBody TeamRequest teamRequest) {
        try {
            TeamResponse teamResponse = teamService.updateTeam(id, teamRequest);
            return ResponseEntity.ok(teamResponse);
        } catch (TeamNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable int id) {
        try {
            teamService.deleteTeam(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (TeamNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}