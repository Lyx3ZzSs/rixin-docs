package com.onlyoffice.integration.repositories;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.onlyoffice.integration.entities.UserDescriptions;

import java.util.List;

public interface UserDescriptionsRepository extends BaseMapper<UserDescriptions> {
    void insertDescriptions(Integer id, List<String> descriptions);

    List<String> getDescriptionsByUserId(Integer uid);
}
