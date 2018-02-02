package com.chris.cpu.processor;

import com.chris.cpu.crawler.AbstractGeekbenchCrawler;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map;

public class GeekbenchDataStorage {

    public void storeData(String filePath, AbstractGeekbenchCrawler geekbenchCrawler){
        Map<String, String> geekbenchData = geekbenchCrawler.crawlGeekbench();
        try{
            FileWriter fileStream = new FileWriter(filePath);
            BufferedWriter out = new BufferedWriter(fileStream);
            for(Map.Entry<String, String> data: geekbenchData.entrySet()){
                out.write(data.getKey() + "," + data.getValue() + "\n");
            }
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
