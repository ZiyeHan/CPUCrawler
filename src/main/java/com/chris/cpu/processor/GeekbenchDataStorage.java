package com.chris.cpu.processor;

import com.chris.cpu.common.FileConstants;
import com.chris.cpu.crawler.AbstractGeekbenchCrawler;
import com.chris.cpu.crawler.DesktopGeekbenchCrawler;
import com.chris.cpu.crawler.MobileGeekbenchCrawler;

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

//    Test
//    public static void main(String[] args){
//        GeekbenchDataStorage gds = new GeekbenchDataStorage();
//        gds.storeData(FileConstants.GEEKBENCH_DESKTOP_FILEPATH, new DesktopGeekbenchCrawler());
//        gds.storeData(FileConstants.GEEKBENCH_MOBILE_FILEPATH, new MobileGeekbenchCrawler());
//
//    }


}
