package com.onlyoffice.integration.repositories;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.onlyoffice.integration.entities.Group;
import com.onlyoffice.integration.entities.PermissionReviewGroups;

import java.util.List;

public interface PermissionReviewGroupsRepository extends BaseMapper<PermissionReviewGroups> {
    void inserReviewGroups(Integer permissionId, List<Group> reviewGroups);
}
