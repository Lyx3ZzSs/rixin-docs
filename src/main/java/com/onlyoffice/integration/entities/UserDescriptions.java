package com.onlyoffice.integration.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user_descriptions")
public class UserDescriptions {
    private Integer userId;
    private String descriptions;
}
