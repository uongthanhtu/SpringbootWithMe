package com.tusry.bmi.core;

public class BmiCalculator {
    public static double getBmi(final double height, final double weight) {
        double bmi = weight / (height * height);
        return bmi;
    }// <18.5 om
    // 18.5 -> 24.9 mlem
    // >=25: map
    //>=30 beo cmn phu
}
