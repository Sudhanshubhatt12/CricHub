package com.Cricbuzz.cricbuzz.convertor;

import com.Cricbuzz.cricbuzz.dto.request.ProfileRequest;
import com.Cricbuzz.cricbuzz.dto.response.ProfileResponse;
import com.Cricbuzz.cricbuzz.model.PlayerProfile;

public class ProfileConvertor {

    public static PlayerProfile profileRequstToProfile(ProfileRequest profileRequest) {
        return PlayerProfile.builder()
                .runsScored(profileRequest.getRunsScored())
                .wicketsTaken(profileRequest.getWicketsTaken())
                .battingAvg(profileRequest.getBattingAvg())
                .bowlingAvg(profileRequest.getBowlingAvg())
                .build();
    }

    public static ProfileResponse profileToProfileResponse(PlayerProfile playerProfile) {
        return ProfileResponse.builder()
                .runsScored(playerProfile.getRunsScored())
                .wicketsTaken(playerProfile.getWicketsTaken())
                .battingAvg(playerProfile.getBattingAvg())
                .bowlingAvg(playerProfile.getBowlingAvg())
                .player(PlayerConvertor.playerToPlayerResponse(playerProfile.getPlayer()))
                .build();
    }
}
