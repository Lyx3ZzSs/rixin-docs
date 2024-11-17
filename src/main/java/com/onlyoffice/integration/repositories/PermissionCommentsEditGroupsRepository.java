package com.onlyoffice.integration.repositories;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.onlyoffice.integration.entities.Group;
import com.onlyoffice.integration.entities.PermissionCommentsEditGroups;

import java.util.List;

public interface PermissionCommentsEditGroupsRepository extends BaseMapper<PermissionCommentsEditGroups> {
    void insertCommentsEditGroups(Integer permissionId, List<Group> commentEditGroups);
}
