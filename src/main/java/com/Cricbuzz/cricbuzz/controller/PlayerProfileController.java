package com.Cricbuzz.cricbuzz.controller;

import com.Cricbuzz.cricbuzz.dto.request.ProfileRequest;
import com.Cricbuzz.cricbuzz.dto.response.ProfileResponse;
import com.Cricbuzz.cricbuzz.exception.PlayerNotFoundException;
import com.Cricbuzz.cricbuzz.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class PlayerProfileController {

    @Autowired
    private ProfileService profileService;

    // Create
    @PostMapping("/{playerId}")
    public ResponseEntity<ProfileResponse> addPlayerProfile(
            @RequestBody ProfileRequest profileRequest,
            @PathVariable int playerId) {
        try {
            ProfileResponse profileResponse = profileService.addPlayerProfile(profileRequest, playerId);
            return new ResponseEntity<>(profileResponse, HttpStatus.CREATED);
        } catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Read All
    @GetMapping
    public ResponseEntity<List<ProfileResponse>> getAllProfiles() {
        List<ProfileResponse> profiles = profileService.getAllProfiles();
        return ResponseEntity.ok(profiles);
    }

    // Read One
    @GetMapping("/{playerId}")
    public ResponseEntity<ProfileResponse> getProfileById(@PathVariable int playerId) {
        try {
            ProfileResponse profileResponse = profileService.getProfileById(playerId);
            return ResponseEntity.ok(profileResponse);
        } catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Update
    @PutMapping("/{playerId}")
    public ResponseEntity<ProfileResponse> updateProfile(
            @PathVariable int playerId,
            @RequestBody ProfileRequest profileRequest) {
        try {
            ProfileResponse profileResponse = profileService.updateProfile(playerId, profileRequest);
            return ResponseEntity.ok(profileResponse);
        } catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping("/{playerId}")
    public ResponseEntity<Void> deleteProfile(@PathVariable int playerId) {
        try {
            profileService.deleteProfile(playerId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (PlayerNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}