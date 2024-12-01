package com.Cricbuzz.cricbuzz.dto.response;


import com.Cricbuzz.cricbuzz.model.enums.Speciality;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class PlayerResponse {

    String name;

    Speciality speciality;
}
