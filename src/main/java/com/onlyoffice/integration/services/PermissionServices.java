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

package com.onlyoffice.integration.services;

import com.onlyoffice.integration.entities.Group;
import com.onlyoffice.integration.entities.Permission;
import com.onlyoffice.integration.entities.PermissionReviewGroups;
import com.onlyoffice.integration.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.function.BiConsumer;

@Service
public class PermissionServices {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private PermissionCommentsEditGroupsRepository permissionCommentsEditGroupsRepository;

    @Autowired
    private PermissionCommentsRemoveGroupsRepository permissionCommentsRemoveGroupsRepository;

    @Autowired
    private PermissionCommentsViewGroupsRepository permissionCommentsViewGroupsRepository;

    @Autowired
    private PermissionReviewGroupsRepository permissionReviewGroupsRepository;

    @Autowired
    private PermissionUserInfoGroupsRepository permissionUserInfoGroupsRepository;

    // create permissions with the specified parameters
    public Permission createPermission(final List<Group> reviewGroups,
                                       final List<Group> commentViewGroups,
                                       final List<Group> commentEditGroups,
                                       final List<Group> commentRemoveGroups,
                                       final List<Group> userInfoGroups,
                                       final Boolean chat,
                                       final Boolean protect,
                                       final Boolean submitForm) {

        Permission permission = new Permission();
        permission.setReviewGroups(reviewGroups);  // define the groups whose changes the user can accept/reject
        permission.setCommentsViewGroups(commentViewGroups);  // defines the groups whose comments the user can view
        permission.setCommentsEditGroups(commentEditGroups);  // defines the groups whose comments the user can edit
        permission.setCommentsRemoveGroups(commentRemoveGroups);  /* defines the groups
         whose comments the user can remove */
        permission.setUserInfoGroups(userInfoGroups);
        permission.setChat(chat);
        permission.setProtect(protect);
        permission.setSubmitForm(submitForm);

        permissionRepository.insert(permission);  // save new permissions
        Integer permissionId = permission.getId();
        /*permissionReviewGroupsRepository.inserReviewGroups(permissionId,reviewGroups);
        permissionCommentsEditGroupsRepository.insertCommentsEditGroups(permissionId,commentEditGroups);
        permissionCommentsRemoveGroupsRepository.insertCommentsRemoveGroups(permissionId,commentRemoveGroups);
        permissionCommentsViewGroupsRepository.insertCommentsViewGroups(permissionId,commentViewGroups);
        permissionUserInfoGroupsRepository.insertUserInfoGroups(permissionId,userInfoGroups);*/
        insertIfNotEmpty(reviewGroups,permissionReviewGroupsRepository::inserReviewGroups,permissionId);
        insertIfNotEmpty(commentEditGroups,permissionCommentsEditGroupsRepository::insertCommentsEditGroups,permissionId);
        insertIfNotEmpty(commentRemoveGroups,permissionCommentsRemoveGroupsRepository::insertCommentsRemoveGroups,permissionId);
        insertIfNotEmpty(commentViewGroups,permissionCommentsViewGroupsRepository::insertCommentsViewGroups,permissionId);
        insertIfNotEmpty(userInfoGroups,permissionUserInfoGroupsRepository::insertUserInfoGroups,permissionId);
        return permission;
    }

    // update permissions
    public Permission updatePermission(final Permission newPermission) {
        permissionRepository.updateById(newPermission);  // save new permissions

        return newPermission;
    }

    private <T> void insertIfNotEmpty(List<T> list, BiConsumer<Integer, List<T>> inserter, Integer permissionId) {
        if (!CollectionUtils.isEmpty(list)) {
            inserter.accept(permissionId, list);
        }
    }


}
