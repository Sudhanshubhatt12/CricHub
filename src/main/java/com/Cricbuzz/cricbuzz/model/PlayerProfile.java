package com.Cricbuzz.cricbuzz.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PlayerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int runsScored;

    int wicketsTaken;

    double battingAvg;

    double bowlingAvg;

    @OneToOne
    @JoinColumn
    @JsonBackReference
    Player player;

}