package com.chris.cpu.crawler;

import com.chris.cpu.common.PageConstants;
import com.chris.cpu.enums.CoreEnum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
        chooseCore(driver, CoreEnum.MULTI_CORE); //Choose multi core
        List<WebElement> allCPUs = driver.findElements(By.xpath("//*[@id=\"android\"]/tbody/tr"));
        for(WebElement cpu: allCPUs){
            String fullCPUName = cpu.findElement(By.xpath(".//td[1]/div[2]")).getText();
            if(fullCPUName.equals("")){  //There are some extra empty records, which I don't need
                break;
            }
            if(fullCPUName.indexOf("@") == 0){
                continue;
            }
            String shortCPUName = fullCPUName.substring(0, fullCPUName.indexOf("@") - 1);
            String cpuBenchscore = cpu.findElement(By.xpath(".//td[2]")).getText();
            crawlResult.put(shortCPUName, cpuBenchscore);
        }
        return crawlResult;
    }

    private void chooseCore(WebDriver driver, CoreEnum coreEnum){
        WebElement tab = driver.findElement(By.cssSelector("a[href=\"" + coreEnum.getCoreOption() + "\"]"));
        tab.click();
    }

}
