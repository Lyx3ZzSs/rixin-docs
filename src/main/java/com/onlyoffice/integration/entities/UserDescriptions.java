package com.onlyoffice.integration.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("user_descriptions")
public class UserDescriptions extends AbstractEntity{
    private Integer userId;
    private String descriptions;
}
