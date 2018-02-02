package com.chris.cpu.processor;


import com.chris.cpu.crawler.AbstractReleaseDateCrawler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;


public class ReleaseDateDataStorage {

    public void storeData(String sourceFilePath, String destinationfilePath, AbstractReleaseDateCrawler abstractReleaseDateCrawler){
        Set<String> cpuNames = getBenchmarkCpuNames(sourceFilePath);
        Map<String, String> releaseDate = abstractReleaseDateCrawler.crawlReleaseDate(cpuNames);
        try{
            FileWriter fileStream = new FileWriter(destinationfilePath);
            BufferedWriter out = new BufferedWriter(fileStream);
            for(Map.Entry<String, String> data: releaseDate.entrySet()){
                out.write(data.getKey() + "," + data.getValue() + "\n");
            }
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private Set<String> getBenchmarkCpuNames(String sourceFilePath){
        Set<String> cpuNames = new HashSet<String>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFilePath));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String benchInfo[] = line.split(",");
                cpuNames.add(benchInfo[0]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return cpuNames;
    }


}
