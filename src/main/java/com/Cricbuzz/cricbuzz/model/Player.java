package com.Cricbuzz.cricbuzz.model;

import com.Cricbuzz.cricbuzz.model.enums.Gender;
import com.Cricbuzz.cricbuzz.model.enums.Speciality;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType
            .IDENTITY)
    int id;

    String name;

    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Enumerated(EnumType.STRING)
    Speciality speciality;

    String email;

    @OneToOne(mappedBy = "player",cascade = CascadeType.ALL)
    @JsonManagedReference
    PlayerProfile profile;

    @ManyToOne
    @JoinColumn
    @JsonManagedReference
    Team team;

}
