package com.chris.cpu.crawler;

import com.chris.cpu.common.PageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.HashMap;
import java.util.List;

public class MobileGeekbenchCrawler extends AbstractGeekbenchCrawler{

    @Override
    protected void openPage() {
        driver.get(PageConstants.GEEKBENCH_MOBILE);
    }

    @Override
    protected HashMap<String, String> crawlTarget() {
        crawlResult = new HashMap<String, String>();
        System.out.println("Crawling mobile geekbench...");
        List<WebElement> allCPUs = driver.findElements(By.xpath("//*[@id=\"android\"]/tbody/tr"));
        for(WebElement cpu: allCPUs){
            String cpuName = cpu.findElement(By.xpath(".//td[1]/a")).getText();
            String cpuBenchscore = cpu.findElement(By.xpath(".//td[2]")).getText();
            if(cpuName.equals("")){  //There are some extra empty records, which I don't need
                break;
            }
            crawlResult.put(cpuName, cpuBenchscore);
        }
        return crawlResult;
    }
}
