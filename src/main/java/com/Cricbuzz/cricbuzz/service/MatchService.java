package com.Cricbuzz.cricbuzz.service;

import com.Cricbuzz.cricbuzz.convertor.MatchConvertor;
import com.Cricbuzz.cricbuzz.dto.request.MatchRequest;
import com.Cricbuzz.cricbuzz.dto.response.MatchResponse;
import com.Cricbuzz.cricbuzz.exception.MatchNotFoundException;
import com.Cricbuzz.cricbuzz.exception.TeamNotFoundException;
import com.Cricbuzz.cricbuzz.model.CricketMatch;
import com.Cricbuzz.cricbuzz.model.Team;
import com.Cricbuzz.cricbuzz.repository.CricketMatchRepository;
import com.Cricbuzz.cricbuzz.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatchService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    CricketMatchRepository matchRepository;

    // Create
    public MatchResponse registerMatch(MatchRequest matchRequest, int teamAId, int teamBId) {
        Optional<Team> teamAOptional = teamRepository.findById(teamAId);
        Optional<Team> teamBOptional = teamRepository.findById(teamBId);
        if (teamAOptional.isEmpty() || teamBOptional.isEmpty()) {
            throw new TeamNotFoundException("One or more team id is not valid");
        }

        Team teamA = teamAOptional.get();
        Team teamB = teamBOptional.get();

        CricketMatch cricketMatch = MatchConvertor.matchRequestToMatch(matchRequest);
        cricketMatch.getTeams().add(teamA);
        cricketMatch.getTeams().add(teamB);

        teamA.getMatches().add(cricketMatch);
        teamB.getMatches().add(cricketMatch);

        CricketMatch savedMatch = matchRepository.save(cricketMatch);
        teamRepository.save(teamA);
        teamRepository.save(teamB);

        return MatchConvertor.matchToMatchRespone(savedMatch);
    }

    // Read All
    public List<MatchResponse> getAllMatches() {
        List<CricketMatch> matches = matchRepository.findAll();
        return matches.stream()
                .map(MatchConvertor::matchToMatchRespone)
                .collect(Collectors.toList());
    }

    // Read One
    public MatchResponse getMatchById(int id) {
        CricketMatch match = matchRepository.findById(id)
                .orElseThrow(() -> new MatchNotFoundException("Match not found with id: " + id));
        return MatchConvertor.matchToMatchRespone(match);
    }

    // Update
    public MatchResponse updateMatch(int id, MatchRequest matchRequest) {
        CricketMatch match = matchRepository.findById(id)
                .orElseThrow(() -> new MatchNotFoundException("Match not found with id: " + id));
        // Update fields as per MatchRequest (assuming it has relevant fields)
        CricketMatch updatedMatch = MatchConvertor.matchRequestToMatch(matchRequest);
        updatedMatch.setId(match.getId()); // Preserve the original ID
        updatedMatch.setTeams(match.getTeams()); // Preserve existing teams
        CricketMatch savedMatch = matchRepository.save(updatedMatch);
        return MatchConvertor.matchToMatchRespone(savedMatch);
    }

    // Delete
    public void deleteMatch(int id) {
        CricketMatch match = matchRepository.findById(id)
                .orElseThrow(() -> new MatchNotFoundException("Match not found with id: " + id));
        // Remove match from associated teams
        match.getTeams().forEach(team -> team.getMatches().remove(match));
        matchRepository.delete(match);
    }
}