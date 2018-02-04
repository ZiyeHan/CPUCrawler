package com.chris.cpu.util;

import java.util.HashSet;
import java.util.Set;

public class WebProcessUtil {

    public static final Set<String> S1_MONTH_DE= new HashSet<String>() {{
        add("01");
        add("02");
        add("03");
        add("04");
        add("05");
        add("06");
    }};

    /**
     * Convert from quarter -> semester
     * @param releaseQuarter
     * @return
     */
    public static String getDesktopReleaseSemester(String releaseQuarter){
        String[] date = releaseQuarter.split(" ");
        if(date[0].equals("Q1") || date[0].equals("Q2")){
            return "S1 " + date[1];
        }else{
            return "S2 " + date[1];
        }
    }

    public static String getMobileReleaseSemesterEN(String releasedate){
        String[] date = releasedate.split("/");
        int month = Integer.valueOf(date[0]);
        if(month <= 6){
            return "S1 " + date[2];
        }else{
            return "S2 " + date[2];
        }
    }

    public static String getMobileReleaseSemesterDE(String releaseDate){
        String[] date = releaseDate.split("\\.");
        if(S1_MONTH_DE.contains(date[1])){
            return "S1 " + date[2];
        }else{
            return "S2 " + date[2];
        }
    }

    public static String getDesktopCpuUrlPostfix(String cpuName){
        return cpuName.replace(" Black Edition", "").replace(" ", "+");
    }

    public static String getMobileCpuUrlPostfix(String cpuName){
        return cpuName.replace(" ", "-") + "-Soc";
    }



}





