package com.suk.zhenya.projects.map.service;

import com.suk.zhenya.projects.map.dto.CrudProjectDto;
import com.suk.zhenya.projects.map.dto.ProjectDetailsDto;
import com.suk.zhenya.projects.map.dto.ProjectDto;

public interface ProjectService {

    ProjectDto createProject(String groupId, CrudProjectDto dto);
    ProjectDetailsDto geProjectDetails(String groupId, String projectId);
}
