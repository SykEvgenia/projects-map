package com.suk.zhenya.projects.map.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrudGroupDto {

    @NotBlank
    @JsonProperty("name")
    private String name;
}
