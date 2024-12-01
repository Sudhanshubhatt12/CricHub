package com.Cricbuzz.cricbuzz.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProfileResponse {

    int runsScored;

    int wicketsTaken;

    double battingAvg;

    double bowlingAvg;

    PlayerResponse player;
}
