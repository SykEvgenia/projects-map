package com.suk.zhenya.projects.map.controller;

import com.suk.zhenya.projects.map.dto.CrudProjectDto;
import com.suk.zhenya.projects.map.dto.ProjectDetailsDto;
import com.suk.zhenya.projects.map.dto.ProjectDto;
import com.suk.zhenya.projects.map.service.ProjectService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService service;

    @PostMapping("/group/{groupId}/project")
    public ProjectDto createProject(@PathVariable("groupId") @NotBlank String groupId, @RequestBody @Valid CrudProjectDto dto) {
        return service.createProject(groupId, dto);
    }

    @GetMapping("/group/{groupId}/project/{projectId}/details")
    public ProjectDetailsDto geProjectDetails(@PathVariable("groupId") @NotBlank String groupId, @PathVariable("projectId") @NotBlank String projectId){
        return service.geProjectDetails(groupId, projectId);
    }
}
