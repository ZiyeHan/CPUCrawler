package com.chris.cpu.util;

public class WebProcessUtil {

    /**
     * Convert from quarter -> semester
     * @param releaseQuarter
     * @return
     */
    public static String getReleaseSemester(String releaseQuarter){
        String[] date = releaseQuarter.split(" ");
        if(date[0].equals("Q1") || date[0].equals("Q2")){
            return "S1 " + date[1];
        }else{
            return "S2 " + date[1];
        }
    }


    public static String getCpuUrlPostfix(String cpuName){
        return cpuName.replace(" Black Edition", "").replace(" ", "+");
    }


}





