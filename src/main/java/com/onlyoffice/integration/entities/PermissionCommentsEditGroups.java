package com.onlyoffice.integration.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("permission_comments_edit_groups")
public class PermissionCommentsEditGroups extends AbstractEntity {
    private Integer permissionId;
    private Integer commentsEditGroupsId;
}
