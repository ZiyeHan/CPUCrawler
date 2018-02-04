package com.chris.cpu.crawler;

import com.chris.cpu.common.PageConstants;
import com.chris.cpu.util.WebProcessUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.HashMap;

public class DesktopReleaseDateCrawler extends AbstractReleaseDateCrawler {

    @Override
    protected boolean openPage(String cpuName) {
        driver.get(PageConstants.DATE_DESKTOP_PREFIX + WebProcessUtil.getDesktopCpuUrlPostfix(cpuName));
        return true;
    }

    @Override
    protected HashMap<String, String> crawlTarget(String cpuName, HashMap<String, String> crawlResult) {
        try {
            String description = driver.findElement(By.xpath(PageConstants.DESKTOP_RELEASE_DATE_LOCATOR)).getText();
            int index = description.indexOf("CPU First Seen on Charts:  ");
            if(index != -1){
                String date = WebProcessUtil.getDesktopReleaseSemester(description.substring(index + 27, index + 34));
                System.out.println("Correct -> " + driver.getCurrentUrl());
                crawlResult.put(cpuName, date);
            }else{
                System.out.println("No Index -> " + driver.getCurrentUrl());
                crawlResult.put(cpuName, "N/A");
            }
        }catch(NoSuchElementException e){
            System.out.println("No Info -> " + driver.getCurrentUrl());
            crawlResult.put(cpuName, "N/A");
        }

        return crawlResult;
    }


}
