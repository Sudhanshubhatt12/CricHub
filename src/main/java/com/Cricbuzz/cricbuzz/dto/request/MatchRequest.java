package com.Cricbuzz.cricbuzz.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MatchRequest {

    String title;

    String venue;

    int noOfOvers;
}
