package com.Cricbuzz.cricbuzz.service;

import com.Cricbuzz.cricbuzz.convertor.ProfileConvertor;
import com.Cricbuzz.cricbuzz.dto.request.ProfileRequest;
import com.Cricbuzz.cricbuzz.dto.response.ProfileResponse;
import com.Cricbuzz.cricbuzz.exception.PlayerNotFoundException;
import com.Cricbuzz.cricbuzz.model.Player;
import com.Cricbuzz.cricbuzz.model.PlayerProfile;
import com.Cricbuzz.cricbuzz.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class ProfileService {

    @Autowired
    PlayerRepository playerRepository;

    public ProfileResponse addPlayerProfile(ProfileRequest profileRequest,
                                            int playerId) {
//        Player player = playerRepository.findById(playerId)
//                .orElseThrow(() -> new PlayerNotFoundException("Invalid Player id"));

        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        if (optionalPlayer.isEmpty()) {
            throw new PlayerNotFoundException("Invalid player Id");
        }
        Player player = optionalPlayer.get();

        PlayerProfile playerProfile = ProfileConvertor.profileRequstToProfile(profileRequest);
        player.setProfile(playerProfile);
        playerProfile.setPlayer(player);

        Player savedPlayer = playerRepository.save(player); // player + playerprofile

        return ProfileConvertor.profileToProfileResponse(savedPlayer.getProfile());
    }
}