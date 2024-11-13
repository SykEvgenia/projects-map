package com.suk.zhenya.projects.map.service;

import com.suk.zhenya.projects.map.dto.CrudGroupDto;
import com.suk.zhenya.projects.map.dto.GroupDto;
import com.suk.zhenya.projects.map.repository.GroupRepository;
import com.suk.zhenya.projects.map.service.converter.Converter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {

    private GroupRepository repository;
    private Converter converter;

    @Override
    public GroupDto createGroup(CrudGroupDto dto) {
        return converter.convertToGroupDto(repository.save(converter.convertToGroup(dto)));
    }
}
