package com.onlyoffice.integration.repositories;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.onlyoffice.integration.entities.Group;
import com.onlyoffice.integration.entities.PermissionUserInfoGroups;

import java.util.List;

public interface PermissionUserInfoGroupsRepository extends BaseMapper<PermissionUserInfoGroups> {
    void insertUserInfoGroups(Integer permissionId, List<Group> userInfoGroups);
}
