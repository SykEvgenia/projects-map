package com.suk.zhenya.projects.map.service.converter;

import com.suk.zhenya.projects.map.dto.CrudGroupDto;
import com.suk.zhenya.projects.map.dto.CrudProjectDto;
import com.suk.zhenya.projects.map.dto.GroupDto;
import com.suk.zhenya.projects.map.dto.ProjectDto;
import com.suk.zhenya.projects.map.entity.Group;
import com.suk.zhenya.projects.map.entity.Project;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Converter {

    public GroupDto convertToGroupDto(Group group) {
        return GroupDto.builder()
                .id(group.getId().toString())
                .name(group.getName())
                .build();
    }

    public Group convertToGroup(CrudGroupDto dto) {
        return Group.builder()
                .name(dto.getName())
                .projects(new ArrayList<>())
                .build();
    }

    public ProjectDto convertToProjectDto(Project project) {
        return ProjectDto.builder()
                .id(project.getId().toString())
                .name(project.getName())
                .webAddress(project.getWebAddress())
                .build();
    }

    public Project convertToProject(CrudProjectDto dto) {
        return Project.builder()
                .id(new ObjectId())
                .name(dto.getName())
                .webAddress(dto.getWebAddress())
                .build();
    }
}
