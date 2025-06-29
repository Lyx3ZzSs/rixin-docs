package com.onlyoffice.integration.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("permission_review_groups")
public class PermissionReviewGroups extends AbstractEntity {
    private Integer permissionId;
    private Integer reviewGroupsId;
}
