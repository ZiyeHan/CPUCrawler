package com.chris.cpu.crawler;

import com.chris.cpu.common.PageConstants;
import com.chris.cpu.util.WebProcessUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import java.util.HashMap;

public class DesktopReleaseDateCrawler extends AbstractReleaseDateCrawler {

    @Override
    protected void openPage(String cpuName) {
        driver.get(PageConstants.DATE_DESKTOP + WebProcessUtil.getCpuUrlPostfix(cpuName));
    }

    @Override
    protected HashMap<String, String> crawlTarget(String cpuName, HashMap<String, String> crawlResult) {
        try {
            String description = driver.findElement(By.xpath("/html/body/center/div[7]/div[1]/table[1]/tbody/tr[2]/td[1]")).getText();
            int index = description.indexOf("CPU First Seen on Charts:  ");
            if(index != -1){
                String date = WebProcessUtil.getReleaseSemester(description.substring(index + 27, index + 34));
                crawlResult.put(cpuName, date);
                System.out.println("Correct -> " + PageConstants.DATE_DESKTOP + WebProcessUtil.getCpuUrlPostfix(cpuName));
            }else{
                crawlResult.put(cpuName, "N/A");
                System.out.println("No Index -> " + PageConstants.DATE_DESKTOP + WebProcessUtil.getCpuUrlPostfix(cpuName));
            }
        }catch(NoSuchElementException e){
            crawlResult.put(cpuName, "N/A");
            System.out.println("No Info -> " + PageConstants.DATE_DESKTOP + WebProcessUtil.getCpuUrlPostfix(cpuName));
        }

        return crawlResult;
    }


}
