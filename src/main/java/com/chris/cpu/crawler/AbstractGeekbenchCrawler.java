package com.chris.cpu.crawler;

import com.chris.cpu.util.DriverUtil;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;

public abstract class AbstractGeekbenchCrawler {

    protected WebDriver driver;

    protected HashMap<String, String> crawlResult;

    public HashMap<String, String> crawlGeekbench() {
        initiateDriver();
        openPage();
        crawlResult = crawlTarget();
        return crawlResult;
    }

    private void initiateDriver(){
        driver = DriverUtil.initiateDriver(driver);
    }

    protected abstract void openPage();

    protected abstract HashMap<String, String> crawlTarget();

}

