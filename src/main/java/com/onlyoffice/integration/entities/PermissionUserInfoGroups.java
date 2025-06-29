package com.onlyoffice.integration.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("permission_user_info_groups")
public class PermissionUserInfoGroups extends AbstractEntity{
    private Integer permissionId;
    private Integer userInfoGroupsId;
}
