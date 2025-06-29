package com.onlyoffice.integration.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("permission_comments_remove_groups")
public class PermissionCommentsRemoveGroups extends AbstractEntity {
    private Integer permissionId;
    private Integer commentsRemoveGroupsId;
}