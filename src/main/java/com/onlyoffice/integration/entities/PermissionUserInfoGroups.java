package com.onlyoffice.integration.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("permission_user_info_groups")
public class PermissionUserInfoGroups {
    private Integer permissionId;
    private Integer userInfoGroupsId;
}
