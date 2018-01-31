package com.chris.cpu.processor;


import com.chris.cpu.crawler.AbstractReleaseDateCrawler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;

public class ReleaseDateDataStorage {

    public void storeData(String filePath, AbstractReleaseDateCrawler abstractReleaseDateCrawler){
        Map<String, String> releaseData = abstractReleaseDateCrawler.crawlReleaseDate(2012, 2017);
        try{
            FileWriter fileStream = new FileWriter(filePath);
            BufferedWriter out = new BufferedWriter(fileStream);
            for(Map.Entry<String, String> data: releaseData.entrySet()){
                out.write(data.getKey() + "," + data.getValue() + "\n");
            }
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
