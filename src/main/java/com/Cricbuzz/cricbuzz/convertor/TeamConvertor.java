package com.Cricbuzz.cricbuzz.convertor;

import com.Cricbuzz.cricbuzz.dto.request.TeamRequest;
import com.Cricbuzz.cricbuzz.dto.response.TeamResponse;
import com.Cricbuzz.cricbuzz.model.Team;

public class TeamConvertor {

    public static Team teamRequestToTeam(TeamRequest teamRequest) {
        return Team.builder()
                .name(teamRequest.getName())
                .ranking(teamRequest.getRanking())
                .iccPoints(teamRequest.getIccPoints())
                .coach(teamRequest.getCoach())
                .build();
    }

    public static TeamResponse teamToTeamResponse(Team team) {
        return TeamResponse.builder()
                .name(team.getName())
                .ranking(team.getRanking())
                .coach(team.getCoach())
                .build();
    }
}
