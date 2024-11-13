package com.suk.zhenya.projects.map.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDetailsDto {

    @JsonProperty("javaVersion")
    private String javaVersion;

    @JsonProperty("springVersion")
    private String springVersion;
}
