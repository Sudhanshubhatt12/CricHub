package com.Cricbuzz.cricbuzz.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;


import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class MatchResponse {

    String title;

    String venue;

    int noOfOvers;

    Date createdAt;

    List<TeamResponse> teams;
}
