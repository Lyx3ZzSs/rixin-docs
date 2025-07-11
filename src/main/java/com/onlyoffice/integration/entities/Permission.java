/**
 *
 * (c) Copyright Ascensio System SIA 2024
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.onlyoffice.integration.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Permission extends AbstractEntity{
    private Boolean comment = true;
    private Boolean copy = true;
    private Boolean download = true;
    private Boolean edit = true;
    private Boolean print = true;
    private Boolean fillForms = true;
    private Boolean submitForm = true;
    private Boolean modifyFilter = true;
    private Boolean modifyContentControl = true;
    private Boolean review = true;
    private Boolean chat = true;
    private Boolean templates = true;
//    @ManyToMany
    @TableField(exist = false)
    private List<Group> reviewGroups;
//    @ManyToMany
    @TableField(exist = false)
    private List<Group> commentsViewGroups;
//    @ManyToMany
    @TableField(exist = false)
    private List<Group> commentsEditGroups;
//    @ManyToMany
    @TableField(exist = false)
    private List<Group> commentsRemoveGroups;
//    @ManyToMany
    @TableField(exist = false)
    private List<Group> userInfoGroups;
    private Boolean protect = true;
}
