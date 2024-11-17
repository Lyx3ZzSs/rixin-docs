package com.onlyoffice.integration.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("permission_comments_remove_groups")
public class PermissionCommentsRemoveGroups {
    private Integer permissionId;
    private Integer commentsRemoveGroupsId;
}