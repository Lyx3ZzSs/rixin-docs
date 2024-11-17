package com.onlyoffice.integration.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("permission_review_groups")
public class PermissionReviewGroups {
    private Integer permissionId;
    private Integer reviewGroupsId;
}
