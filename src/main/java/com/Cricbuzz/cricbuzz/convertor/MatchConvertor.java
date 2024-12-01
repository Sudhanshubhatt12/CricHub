package com.Cricbuzz.cricbuzz.convertor;

import com.Cricbuzz.cricbuzz.dto.request.MatchRequest;
import com.Cricbuzz.cricbuzz.dto.response.MatchResponse;
import com.Cricbuzz.cricbuzz.dto.response.TeamResponse;
import com.Cricbuzz.cricbuzz.model.CricketMatch;
import com.Cricbuzz.cricbuzz.model.Team;

import java.util.ArrayList;
import java.util.List;

public class MatchConvertor {

    public static CricketMatch matchRequestToMatch(MatchRequest matchRequest) {
        return CricketMatch.builder()
                .title(matchRequest.getTitle())
                .venue(matchRequest.getVenue())
                .noOfOvers(matchRequest.getNoOfOvers())
                .teams(new ArrayList<>())
                .build();
    }

    public static MatchResponse matchToMatchRespone(CricketMatch match) {

        Team teamA = match.getTeams().get(0);
        Team teamB = match.getTeams().get(1);
        List<TeamResponse> teamResponses = new ArrayList<>();
        teamResponses.add(TeamConvertor.teamToTeamResponse(teamA));
        teamResponses.add(TeamConvertor.teamToTeamResponse(teamB));

        return MatchResponse.builder()
                .title(match.getTitle())
                .noOfOvers(match.getNoOfOvers())
                .venue(match.getVenue())
                .createdAt(match.getCreatedAt())
                .teams(teamResponses)
                .build();
    }
}
