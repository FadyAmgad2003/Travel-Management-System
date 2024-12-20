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
public class TravelPackageFactory {
    public static TravelPackage createPackage(String packageType) {
        switch (packageType) {
            case "Luxury":
                return new LuxuryPackage();
            case "Adventure":
                return new AdventurePackage();
            case "Cultural":
                return new CulturalPackage();
            default:
                return null;
        }
    }

}
