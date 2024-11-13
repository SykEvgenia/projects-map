package com.suk.zhenya.projects.map.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActuatorInfoDto {

    @JsonProperty("java")
    private Version java;

    @JsonProperty("spring-boot")
    private Version springBoot;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Version {

        @JsonProperty("version")
        private String version;
    }
}
