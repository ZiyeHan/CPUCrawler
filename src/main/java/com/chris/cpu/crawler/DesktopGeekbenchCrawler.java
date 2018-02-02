package com.chris.cpu.crawler;

import com.chris.cpu.common.PageConstants;
import com.chris.cpu.enums.CoreEnum;
import org.openqa.selenium.*;
import java.util.HashMap;
import java.util.List;

public class DesktopGeekbenchCrawler extends AbstractGeekbenchCrawler {

    @Override
    protected void openPage() {
        driver.get(PageConstants.GEEKBENCH_DESKTOP);
    }

    @Override
    protected HashMap<String, String> crawlTarget() {
        crawlResult = new HashMap<String, String>();
        System.out.println("Crawling desktop geekbench...");
        chooseCore(driver, CoreEnum.MULTI_CORE); //Choose multi core
        List<WebElement> allCPUs = driver.findElements(By.xpath("//*[@id=\"pc\"]/tbody/tr"));
        for(WebElement cpu: allCPUs){
            String cpuName = cpu.findElement(By.xpath(".//td[1]/a")).getText();
            String cpuBenchscore = cpu.findElement(By.xpath(".//td[2]")).getText();
            if(cpuName.equals("")){  //There are some extra empty records, which I don't need
                continue;
            }
            crawlResult.put(cpuName, cpuBenchscore);
        }
        return crawlResult;
    }


    private void chooseCore(WebDriver driver, CoreEnum coreEnum){
        WebElement tab = driver.findElement(By.cssSelector("a[href=\"" + coreEnum.getCoreOption() + "\"]"));
        tab.click();
    }


}
