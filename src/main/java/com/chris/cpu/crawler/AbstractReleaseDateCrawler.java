package com.chris.cpu.crawler;

import com.chris.cpu.util.DriverUtil;
import org.openqa.selenium.WebDriver;

import java.util.*;

public abstract class AbstractReleaseDateCrawler {

    protected WebDriver driver;

    protected HashMap<String, String> crawlResult = new HashMap<String, String>();

    public HashMap<String, String> crawlReleaseDate(Set<String> cpuNames) {
        initiateDriver();
        for (String cpuName : cpuNames) {
            boolean hasPage = openPage(cpuName);
            if(hasPage == true) {
                crawlResult = crawlTarget(cpuName, crawlResult);
            }
        }
        return crawlResult;
    }

    private void initiateDriver(){
        driver = DriverUtil.initiateDriver(driver);
    }

    protected abstract boolean openPage(String cpuName);

    protected abstract HashMap<String, String> crawlTarget(String cpuName, HashMap<String, String> crawlResult);


}
