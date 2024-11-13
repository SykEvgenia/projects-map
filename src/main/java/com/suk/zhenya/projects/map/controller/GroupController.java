package com.suk.zhenya.projects.map.controller;

import com.suk.zhenya.projects.map.dto.CrudGroupDto;
import com.suk.zhenya.projects.map.dto.GroupDto;
import com.suk.zhenya.projects.map.service.GroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GroupController {

    private final GroupService service;

    @PostMapping("/group")
    public GroupDto createGroup(@RequestBody @Valid CrudGroupDto dto) {
        return service.createGroup(dto);
    }
}
