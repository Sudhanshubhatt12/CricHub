package com.Cricbuzz.cricbuzz.controller;


import com.Cricbuzz.cricbuzz.dto.request.PlayerRequest;
import com.Cricbuzz.cricbuzz.dto.response.PlayerResponse;
import com.Cricbuzz.cricbuzz.model.PlayerProfile;
import com.Cricbuzz.cricbuzz.model.enums.Speciality;
import com.Cricbuzz.cricbuzz.service.PlayerService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/player")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PostMapping
    public PlayerResponse addPlayer(@RequestBody PlayerRequest playerRequest) {
        return playerService.addPlayer(playerRequest);
    }

    @GetMapping("/age/{age}")
    public List<PlayerResponse> getAllByAgeGreaterThan(@PathVariable("age") int age) {
        return playerService.getAllByAgeGreaterThan(age);
    }

    @GetMapping("/age/{age}/speciality/{speciality}")
    public List<PlayerResponse> getAllByAgeGreaterThanAndSpeciality(@PathVariable("age") int age,
                                                                    @PathVariable("speciality") Speciality speciality) {
        return playerService.getAllByAgeGreaterThanAndSpeciality(age,speciality);
    }

//    @GetMapping
//    public PlayerProfile getPlayer(@RequestParam int playerId) {
//        return playerService.getPlayer(playerId);
//    }

}
