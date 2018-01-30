package com.chris.cpu.crawler;


import com.chris.cpu.common.PageConstants;
import com.chris.cpu.util.DriverUtil;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;

public class DesktopGeekbenchCrawler {

    private WebDriver driver;

    private HashMap<String, String> crawlResult;

    public HashMap<String, String> crawlGeekbench() {
        initiateDriver();
        openPage();
        crawlResult = crawlTarget();
        return crawlResult;
    }

    private void initiateDriver() {
        driver = DriverUtil.initiateDriver(driver);
    }

    private void openPage() {
        driver.get(PageConstants.GEEKBENCH_DESKTOP);
    }

    private HashMap<String, String> crawlTarget() {

        return new HashMap<String, String>();


    }

}


