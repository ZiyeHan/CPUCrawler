package com.chris.cpu.util;

public class WebProcessUtil {

    public static String getReleaseTime(int year, int month){
        if(month <= 6){
            return year + " 1 Semester";
        }else{
            return year + " 2 Semester";
        }
    }

}
