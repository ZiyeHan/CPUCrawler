package com.chris.cpu.crawler;

import com.chris.cpu.common.PageConstants;
import com.chris.cpu.util.WebProcessUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class MobileReleaseDatesCrawler extends AbstractReleaseDateCrawler{

    @Override
    protected void openPage(int year) {
        driver.get(PageConstants.DATE_MOBILE + "_(" + year + ").html");
    }

    @Override
    protected HashMap<String, String> crawlTarget(int year, HashMap<String, String> crawlResult) {
        System.out.println("Crawling mobile release date from year " + year + "...");

        List<WebElement> allMonths = driver.findElements(By.xpath("//*[@id=\"AB_B\"]/div[2]/div[2]/div/div[1]/table/tbody/tr"));
        int monthCounter = 0;
        for(WebElement month: allMonths){
            if(monthCounter == 0){
                monthCounter++;
                continue;
            }
            String releaseTime = WebProcessUtil.getReleaseTime(year, monthCounter);

            crawlAMDCPUs(month, crawlResult, releaseTime);
            crawlIntelCPUs(month, crawlResult, releaseTime);

            monthCounter++;
        }
        return crawlResult;
    }


    private void crawlAMDCPUs(WebElement month, HashMap<String, String> crawlResult, String releaseTime){
        List<WebElement> AMDCPUs = month.findElements(By.xpath(".//td[2]/div/a"));
        for(WebElement AMDCPU: AMDCPUs){
            String AMDCPUName = AMDCPU.getText();
            if(AMDCPUName.contains("(")){
                crawlResult.put("AMD " + AMDCPUName.substring(0, AMDCPUName.indexOf('(')), releaseTime);
            }else{
                crawlResult.put("AMD " + AMDCPUName, releaseTime);
            }
        }
    }

    private void crawlIntelCPUs(WebElement month, HashMap<String, String> crawlResult, String releaseTime){
        List<WebElement> IntelCPUs = month.findElements(By.xpath(".//td[3]/div/a"));
        for(WebElement IntelCPU: IntelCPUs){
            String IntelCPUName = IntelCPU.getText();
            if(IntelCPUName.contains("(")){
                crawlResult.put("Intel " + IntelCPUName.substring(0, IntelCPUName.indexOf('(')), releaseTime);
            }else{
                crawlResult.put("Intel " + IntelCPUName, releaseTime);
            }
        }
    }


}



