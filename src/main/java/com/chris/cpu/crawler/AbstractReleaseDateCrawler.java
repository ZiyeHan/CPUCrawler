package com.chris.cpu.crawler;

import com.chris.cpu.util.DriverUtil;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public abstract class AbstractReleaseDateCrawler {

    protected WebDriver driver;

    protected HashMap<String, String> crawlResult = new HashMap<String, String>();

    public HashMap<String, String> crawlReleaseDate(int startYear, int endYear) {
        initiateDriver();
        for(int i = startYear; i <= endYear; i++){
            openPage(i);
            crawlResult = crawlTarget(i, crawlResult);
        }
        return crawlResult;
    }

    private void initiateDriver(){
        driver = DriverUtil.initiateDriver(driver);
    }

    protected abstract void openPage(int year);

    protected abstract HashMap<String, String> crawlTarget(int year, HashMap<String, String> crawlResult);


}
