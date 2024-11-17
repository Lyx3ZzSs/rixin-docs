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

package com.onlyoffice.integration.repositories;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.onlyoffice.integration.entities.User;

import java.util.List;

public interface UserRepository extends BaseMapper<User> {
    void insertNewUser(User newUser);

    List<User> findAll();



    List<User> getUserListByGroupId(Integer groupId);

    User getUserById(Integer id);
}
