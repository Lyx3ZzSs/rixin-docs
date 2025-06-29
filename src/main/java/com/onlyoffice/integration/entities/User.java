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

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
public class User extends AbstractEntity{
    private String name;
    private String email;
    private Boolean favorite;
//    @ManyToOne
    @TableField(exist = false)
    private Group group;
//    @OneToOne
    @TableField(exist = false)
    private Permission permissions;
//    @Column(columnDefinition = "CLOB")
//    @ElementCollection
//    @CollectionTable(name = "user_descriptions")
    @TableField(exist = false)
    private List<String> descriptions;
    private Boolean avatar;
    private String image;
    @TableField(exist = false)
    private Goback goback;
}
