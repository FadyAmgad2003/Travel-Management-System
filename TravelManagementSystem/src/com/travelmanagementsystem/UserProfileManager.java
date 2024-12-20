/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelmanagementsystem;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dell
 */
    public class UserProfileManager {
    private static UserProfileManager instance;
    private final Map<String, UserProfile> userProfiles;

    private UserProfileManager() {
        this.userProfiles = new HashMap<>();
    }

    public static UserProfileManager getInstance() {
        if (instance == null) {
            instance = new UserProfileManager();
        }
        return instance;
    }

    public void addUserProfile(UserProfile userProfile) {
        userProfiles.put(userProfile.getUsername(), userProfile);
    }

    public UserProfile getUserProfile(String username) {
        return userProfiles.get(username);
    }
}
