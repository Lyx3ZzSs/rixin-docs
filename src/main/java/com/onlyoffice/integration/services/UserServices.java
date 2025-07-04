/**
 * (c) Copyright Ascensio System SIA 2024
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.onlyoffice.integration.services;

import com.onlyoffice.integration.entities.Goback;
import com.onlyoffice.integration.entities.Group;
import com.onlyoffice.integration.entities.Permission;
import com.onlyoffice.integration.entities.User;
import com.onlyoffice.integration.repositories.GobackRepository;
import com.onlyoffice.integration.repositories.UserDescriptionsRepository;
import com.onlyoffice.integration.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupServices groupServices;

    @Autowired
    private PermissionServices permissionService;

    @Autowired
    private UserDescriptionsRepository userDescriptionsRepository;

    @Autowired
    private GobackRepository gobackRepository;

    // get a list of all users
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // get a user by their ID
    public Optional<User> findUserById(final Integer id) {
        return Optional.ofNullable(userRepository.getUserById(id));
    }

    // create a user with the specified parameters
    public User createUser(final String name, final String email,
                           final List<String> descriptions, final String group,
                           final List<String> reviewGroups,
                           final List<String> viewGroups,
                           final List<String> editGroups,
                           final List<String> removeGroups,
                           final List<String> userInfoGroups, final Boolean favoriteDoc,
                           final Boolean chat,
                           final Boolean protect,
                           final Boolean avatar,
                           final Goback goback,
                           final Boolean submitForm) {
        User newUser = new User();
        newUser.setName(name);  // set the user name
        newUser.setEmail(email);  // set the user email
        newUser.setGroup(groupServices.createGroup(group));  // set the user group
        newUser.setDescriptions(descriptions);  // set the user description
        newUser.setFavorite(favoriteDoc);  // specify if the user has the favorite documents or not
        newUser.setAvatar(avatar);

        List<Group> groupsReview = groupServices
                .createGroups(reviewGroups);  // define the groups whose changes the user can accept/reject
        List<Group> commentGroupsView = groupServices
                .createGroups(viewGroups);  // defines the groups whose comments the user can view
        List<Group> commentGroupsEdit = groupServices
                .createGroups(editGroups);  // defines the groups whose comments the user can edit
        List<Group> commentGroupsRemove = groupServices
                .createGroups(removeGroups);  // defines the groups whose comments the user can remove
        List<Group> usInfoGroups = groupServices.createGroups(userInfoGroups);

        Permission permission = permissionService
                .createPermission(groupsReview,
                        commentGroupsView,
                        commentGroupsEdit,
                        commentGroupsRemove,
                        usInfoGroups,
                        chat,
                        protect,
                        submitForm);  // specify permissions for the current user
        newUser.setPermissions(permission);

        Optional.ofNullable(goback).ifPresent(g -> gobackRepository.insert(goback));
        newUser.setGoback(goback);
        userRepository.insertNewUser(newUser); // save a new user
        userDescriptionsRepository.insertDescriptions(newUser.getId(), descriptions);
        return newUser;
    }

    public User getCurrentUser() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();

        Cookie[] cookies = request.getCookies();

        String uid = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("uid")) {
                    uid = cookie.getValue();
                }
            }
        }

        if (uid == null || uid.isEmpty()) {
            return null;
        }

        Optional<User> optionalUser = this.findUserById(Integer.parseInt(uid));

        return optionalUser.get();
    }
}
