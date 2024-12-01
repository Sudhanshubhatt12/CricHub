package com.Cricbuzz.cricbuzz.service;

import com.Cricbuzz.cricbuzz.convertor.MatchConvertor;
import com.Cricbuzz.cricbuzz.dto.request.MatchRequest;
import com.Cricbuzz.cricbuzz.dto.response.MatchResponse;
import com.Cricbuzz.cricbuzz.exception.TeamNotFoundException;
import com.Cricbuzz.cricbuzz.model.CricketMatch;
import com.Cricbuzz.cricbuzz.model.Team;
import com.Cricbuzz.cricbuzz.repository.CricketMatchRepository;
import com.Cricbuzz.cricbuzz.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    CricketMatchRepository matchRepository;

    public MatchResponse registerMatch(MatchRequest matchRequest, int teamAId, int teamBId) {
        Optional<Team> teamAOptional = teamRepository.findById(teamAId);
        Optional<Team> teamBOptional = teamRepository.findById(teamBId);
        if(teamAOptional.isEmpty() || teamBOptional.isEmpty()) {
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
}
