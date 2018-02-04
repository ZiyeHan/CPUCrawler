package com.chris.cpu.crawler;

import com.chris.cpu.common.PageConstants;
import com.chris.cpu.util.WebProcessUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import java.util.HashMap;

public class MobileReleaseDateCrawler extends AbstractReleaseDateCrawler {

    /**
     *
     * @param cpuName
     * @return weather has a real page
     */
    @Override
    protected boolean openPage(String cpuName) {
        driver.get(PageConstants.DATE_MOBILE_PREFIX + WebProcessUtil.getMobileCpuUrlPostfix(cpuName) + ".html");
        //Go to real page
        try {
            driver.findElement(By.xpath(PageConstants.MOBILE_RELEASE_DATE_REAL_PAGE_LOCATOR)).click();
            return true;
        }catch(NoSuchElementException e){
            System.out.println("No Page -> " + cpuName);
            return false;
        }
    }

    @Override
    protected HashMap<String, String> crawlTarget(String cpuName, HashMap<String, String> crawlResult) {
        try {
            String language = driver.findElement(By.xpath("/html")).getAttribute("lang");
            String releaseDate, releaseSemester;
            if(language.equals("en")){
                releaseDate = driver.findElement(By.xpath(PageConstants.MOBILE_RELEASE_DATE_LOCATOR_EN)).getText().substring(0, 10);
                releaseSemester = WebProcessUtil.getMobileReleaseSemesterEN(releaseDate);
                System.out.println("Correct -> CPU: " + cpuName + " URL: " + driver.getCurrentUrl());
            }else if(language.equals("de")){
                releaseDate = driver.findElement(By.xpath(PageConstants.MOBILE_RELEASE_DATE_LOCATOR_DE)).getText().substring(0, 10);
                releaseSemester = WebProcessUtil.getMobileReleaseSemesterDE(releaseDate);
                System.out.println("Correct -> CPU: " + cpuName + " URL: " + driver.getCurrentUrl());
            }else{
                releaseSemester = "N/A";
                System.out.println("Strange Language -> CPU: " + cpuName + " URL: " + driver.getCurrentUrl());
            }
            crawlResult.put(cpuName, releaseSemester);
        }catch(NoSuchElementException e){
            System.out.println("No Info -> CPU: " + cpuName + " URL: " + driver.getCurrentUrl());
            crawlResult.put(cpuName, "N/A");
        }
        return crawlResult;
    }

}
