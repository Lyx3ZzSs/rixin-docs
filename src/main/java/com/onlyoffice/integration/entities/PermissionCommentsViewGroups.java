package com.onlyoffice.integration.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("permission_comments_view_groups")
public class PermissionCommentsViewGroups extends AbstractEntity {
    private Integer permissionId;
    private Integer commentsViewGroupsId;
}
