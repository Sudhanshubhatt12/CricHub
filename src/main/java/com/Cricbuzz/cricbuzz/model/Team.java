package com.Cricbuzz.cricbuzz.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Column(name="ranking",unique = true)
    int ranking;

    int iccPoints;

    String coach;

    @OneToMany(mappedBy = "team")
    @JsonBackReference
    List<Player> players;

    @ManyToMany(mappedBy = "teams")
    @JsonBackReference
    List<CricketMatch> matches;
}
