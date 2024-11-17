package com.onlyoffice.integration.repositories;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.onlyoffice.integration.entities.Group;
import com.onlyoffice.integration.entities.PermissionCommentsViewGroups;

import java.util.List;

public interface PermissionCommentsViewGroupsRepository extends BaseMapper<PermissionCommentsViewGroups> {
    void insertCommentsViewGroups(Integer permissionId, List<Group> commentViewGroups);
}
