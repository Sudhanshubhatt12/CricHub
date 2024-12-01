package com.Cricbuzz.cricbuzz.convertor;

import com.Cricbuzz.cricbuzz.dto.request.PlayerRequest;
import com.Cricbuzz.cricbuzz.dto.response.PlayerResponse;
import com.Cricbuzz.cricbuzz.model.Player;

public class PlayerConvertor {

    public static Player playerRequestToPlayer(PlayerRequest playerRequest) {
        return Player.builder()
                .name(playerRequest.getName())
                .age(playerRequest.getAge())
                .gender(playerRequest.getGender())
                .speciality(playerRequest.getSpeciality())
                .email(playerRequest.getEmail())
                .build();
    }

    public static PlayerResponse playerToPlayerResponse(Player player) {
        return PlayerResponse.builder()
                .name(player.getName())
                .speciality(player.getSpeciality())
                .build();
    }
}