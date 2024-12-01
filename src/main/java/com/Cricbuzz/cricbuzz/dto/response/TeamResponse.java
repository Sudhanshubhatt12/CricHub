package com.Cricbuzz.cricbuzz.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TeamResponse {

    String name;

    int ranking;

    String coach;
}
