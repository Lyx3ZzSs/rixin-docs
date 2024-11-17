package com.onlyoffice.integration.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("permission_comments_edit_groups")
public class PermissionCommentsEditGroups {
    private Integer permissionId;
    private Integer commentsEditGroupsId;
}
