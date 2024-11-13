package com.suk.zhenya.projects.map.service;

import com.suk.zhenya.projects.map.dto.ActuatorInfoDto;
import com.suk.zhenya.projects.map.dto.CrudProjectDto;
import com.suk.zhenya.projects.map.dto.ProjectDetailsDto;
import com.suk.zhenya.projects.map.dto.ProjectDto;
import com.suk.zhenya.projects.map.entity.Group;
import com.suk.zhenya.projects.map.entity.Project;
import com.suk.zhenya.projects.map.exception.GroupNotFoundException;
import com.suk.zhenya.projects.map.exception.ProjectNotFoundException;
import com.suk.zhenya.projects.map.repository.GroupRepository;
import com.suk.zhenya.projects.map.service.converter.Converter;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private GroupRepository repository;
    private RestTemplate restTemplate;
    private Converter converter;

    @Override
    public ProjectDto createProject(String groupId, CrudProjectDto dto) {
        Group group = repository.findById(new ObjectId(groupId))
                .orElseThrow(() -> new GroupNotFoundException("Group not found"));
        Project project = converter.convertToProject(dto);
        group.getProjects().add(project);
        repository.save(group);
        return converter.convertToProjectDto(project);
    }

    @Override
    public ProjectDetailsDto geProjectDetails(String groupId, String projectId) {
        String webAddress = getProject(groupId, projectId).getWebAddress();
        ActuatorInfoDto dto = restTemplate.getForObject(webAddress, ActuatorInfoDto.class);
        return ProjectDetailsDto.builder()
                .javaVersion(dto.getJava().getVersion())
                .springVersion(dto.getSpringBoot().getVersion())
                .build();
    }

    private Project getProject(String groupId, String projectId) {
        return repository.findById(new ObjectId(groupId))
                .orElseThrow(() -> new GroupNotFoundException("Group not found"))
                .getProjects().stream()
                .filter(project -> project.getId().toString().equals(projectId))
                .findFirst().orElseThrow(() -> new ProjectNotFoundException("Project not found"));
    }
}
