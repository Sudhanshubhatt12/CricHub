package com.Cricbuzz.cricbuzz.controller;

import com.Cricbuzz.cricbuzz.dto.request.MatchRequest;
import com.Cricbuzz.cricbuzz.dto.response.MatchResponse;
import com.Cricbuzz.cricbuzz.exception.MatchNotFoundException;
import com.Cricbuzz.cricbuzz.exception.TeamNotFoundException;
import com.Cricbuzz.cricbuzz.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    // Create
    @PostMapping("/teamA/{teamAId}/teamB/{teamBId}")
    public ResponseEntity<MatchResponse> registerMatch(
            @RequestBody MatchRequest matchRequest,
            @PathVariable int teamAId,
            @PathVariable int teamBId) {
        try {
            MatchResponse matchResponse = matchService.registerMatch(matchRequest, teamAId, teamBId);
            return new ResponseEntity<>(matchResponse, HttpStatus.CREATED);
        } catch (TeamNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Read All
    @GetMapping
    public ResponseEntity<List<MatchResponse>> getAllMatches() {
        List<MatchResponse> matches = matchService.getAllMatches();
        return ResponseEntity.ok(matches);
    }

    // Read One
    @GetMapping("/{id}")
    public ResponseEntity<MatchResponse> getMatchById(@PathVariable int id) {
        try {
            MatchResponse matchResponse = matchService.getMatchById(id);
            return ResponseEntity.ok(matchResponse);
        } catch (MatchNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<MatchResponse> updateMatch(
            @PathVariable int id,
            @RequestBody MatchRequest matchRequest) {
        try {
            MatchResponse matchResponse = matchService.updateMatch(id, matchRequest);
            return ResponseEntity.ok(matchResponse);
        } catch (MatchNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable int id) {
        try {
            matchService.deleteMatch(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (MatchNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}