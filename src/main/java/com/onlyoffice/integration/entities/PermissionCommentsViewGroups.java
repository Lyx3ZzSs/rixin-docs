package com.onlyoffice.integration.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("permission_comments_view_groups")
public class PermissionCommentsViewGroups {
    private Integer permissionId;
    private Integer commentsViewGroupsId;
}
