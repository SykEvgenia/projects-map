package com.suk.zhenya.projects.map.service;

import com.suk.zhenya.projects.map.dto.CrudGroupDto;
import com.suk.zhenya.projects.map.dto.GroupDto;

public interface GroupService {

    GroupDto createGroup(CrudGroupDto dto);
}
