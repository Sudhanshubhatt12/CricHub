package com.Cricbuzz.cricbuzz.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TeamRequest {

    String name;

    int ranking;

    int iccPoints;

    String coach;
}
