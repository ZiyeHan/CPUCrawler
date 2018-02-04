package com.chris.cpu.processor;

import com.chris.cpu.common.FileConstants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestScoreStorage {

    private void storeBestScoreEachSemester(HashMap<String, Integer> bestScorePerSem, String storeFilePath){
        try{
            FileWriter fileStream = new FileWriter(storeFilePath);
            BufferedWriter out = new BufferedWriter(fileStream);
            for(Map.Entry<String, Integer> data: bestScorePerSem.entrySet()){
                out.write(data.getKey() + "," + data.getValue() + "\n");
            }
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private HashMap<String, Integer> findBestScoreEachSemester(String scoreFilePath, String dateFilePath){
        HashMap<String, String> scoreMap = getHashMapFromFile(scoreFilePath);
        HashMap<String, String> dateMap = getHashMapFromFile(dateFilePath);
        HashMap<String, List<String>> cpusGroupBySem = groupCPUBySem(dateMap);
        return groupScoreBySem(cpusGroupBySem, scoreMap);
    }


    private HashMap<String, String> getHashMapFromFile(String csvFilePath){
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

    private HashMap<String, List<String>> groupCPUBySem(HashMap<String, String> dateMap){
        HashMap<String, List<String>> cpusGroupBySem = new HashMap<String, List<String>>();
        for(Map.Entry<String, String> cpuDate : dateMap.entrySet()){
            String cpuName = cpuDate.getKey();
            String date = cpuDate.getValue();
            List<String> cpuNameList;
            if(cpusGroupBySem.containsKey(date)){
                cpuNameList = cpusGroupBySem.get(date);
            }else{
                cpuNameList = new ArrayList<String>();
            }
            cpuNameList.add(cpuName);
            cpusGroupBySem.put(date, cpuNameList);
        }
        return cpusGroupBySem;
    }

    private HashMap<String, Integer> groupScoreBySem(HashMap<String, List<String>> cpusGourpBySem, HashMap<String, String> scoreMap){
        HashMap<String, Integer> scoresGroupBySem = new HashMap<String, Integer>();
        for(Map.Entry<String, List<String>> cpuListBySem: cpusGourpBySem.entrySet()){
            List<String> cpuList = cpuListBySem.getValue();
            int max = 0;
            for(String cpuName: cpuList){
                int currentScore = Integer.valueOf(scoreMap.get(cpuName));
                if(currentScore > max){
                    max = currentScore;
                }
            }
            scoresGroupBySem.put(cpuListBySem.getKey(), max);
        }
        return scoresGroupBySem;
    }

}
