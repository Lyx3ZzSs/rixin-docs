package com.onlyoffice.integration.repositories;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.onlyoffice.integration.entities.Group;
import com.onlyoffice.integration.entities.PermissionCommentsRemoveGroups;

import java.util.List;

public interface PermissionCommentsRemoveGroupsRepository extends BaseMapper<PermissionCommentsRemoveGroups> {
    void insertCommentsRemoveGroups(Integer permissionId, List<Group> commentRemoveGroups);
}
