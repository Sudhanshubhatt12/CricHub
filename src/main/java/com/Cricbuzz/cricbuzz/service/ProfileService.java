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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfileService {

    @Autowired
    PlayerRepository playerRepository;

    // Create
    public ProfileResponse addPlayerProfile(ProfileRequest profileRequest, int playerId) {
        Optional<Player> optionalPlayer = playerRepository.findById(playerId);
        if (optionalPlayer.isEmpty()) {
            throw new PlayerNotFoundException("Invalid player Id");
        }
        Player player = optionalPlayer.get();

        PlayerProfile playerProfile = ProfileConvertor.profileRequstToProfile(profileRequest);
        player.setProfile(playerProfile);
        playerProfile.setPlayer(player);

        Player savedPlayer = playerRepository.save(player);
        return ProfileConvertor.profileToProfileResponse(savedPlayer.getProfile());
    }

    // Read All
    public List<ProfileResponse> getAllProfiles() {
        List<Player> players = playerRepository.findAll();
        return players.stream()
                .filter(player -> player.getProfile() != null)
                .map(player -> ProfileConvertor.profileToProfileResponse(player.getProfile()))
                .collect(Collectors.toList());
    }

    // Read One
    public ProfileResponse getProfileById(int playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with id: " + playerId));
        if (player.getProfile() == null) {
            throw new PlayerNotFoundException("Profile not found for player id: " + playerId);
        }
        return ProfileConvertor.profileToProfileResponse(player.getProfile());
    }

    // Update
    public ProfileResponse updateProfile(int playerId, ProfileRequest profileRequest) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with id: " + playerId));
        if (player.getProfile() == null) {
            throw new PlayerNotFoundException("Profile not found for player id: " + playerId);
        }
        PlayerProfile profile = player.getProfile();
        profile.setRunsScored(profileRequest.getRunsScored());
        profile.setWicketsTaken(profileRequest.getWicketsTaken());
        profile.setBattingAvg(profileRequest.getBattingAvg());
        profile.setBowlingAvg(profileRequest.getBowlingAvg());
        Player savedPlayer = playerRepository.save(player);
        return ProfileConvertor.profileToProfileResponse(savedPlayer.getProfile());
    }

    // Delete
    public void deleteProfile(int playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with id: " + playerId));
        if (player.getProfile() == null) {
            throw new PlayerNotFoundException("Profile not found for player id: " + playerId);
        }
        player.setProfile(null); // Remove profile association
        playerRepository.save(player);
    }
}