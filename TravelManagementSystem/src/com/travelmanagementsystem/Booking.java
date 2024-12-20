package com.travelmanagementsystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
    public class Booking {
    private final TravelPackage TravelPackage;
    private final Accommodation Accommodation;
    private final UserProfile UserProfile;

    public Booking(TravelPackage travelPackage, Accommodation accommodation, UserProfile userProfile) {
        this.TravelPackage = travelPackage;
        this.Accommodation = accommodation;
        this.UserProfile = userProfile;
    }
}

