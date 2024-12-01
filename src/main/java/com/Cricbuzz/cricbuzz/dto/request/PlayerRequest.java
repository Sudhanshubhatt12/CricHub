package com.Cricbuzz.cricbuzz.dto.request;


import com.Cricbuzz.cricbuzz.model.enums.Gender;
import com.Cricbuzz.cricbuzz.model.enums.Speciality;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PlayerRequest {

    String name;

    int age;

    Gender gender;

    Speciality speciality;

    String email;
}
