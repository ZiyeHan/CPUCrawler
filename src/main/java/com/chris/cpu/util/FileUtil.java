package com.chris.cpu.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class FileUtil {

    public static HashMap<String, String> getHashMapFromFile(String csvFilePath){
        HashMap<String, String> map = new HashMap<String, String>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilePath));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String benchInfo[] = line.split(",");
                map.put(benchInfo[0], benchInfo[1]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

}
