package com.suk.zhenya.projects.map.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;
}
