package com.chris.cpu.crawler;

import com.chris.cpu.util.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.jvm.hotspot.utilities.WorkerThread;

import java.util.*;
import java.util.concurrent.*;

public abstract class AbstractReleaseDateCrawler {

    protected WebDriver driver;

    protected HashMap<String, String> crawlResult = new HashMap<String, String>();

    public HashMap<String, String> crawlReleaseDate(Set<String> cpuNames) {
        initiateDriver();
        for (String cpuName : cpuNames) {
            openPage(cpuName);
            try {
                driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
                crawlResult = crawlTarget(cpuName, crawlResult);
            }catch(TimeoutException e){
                e.printStackTrace();
            }
        }
        return crawlResult;

//        ExecutorService exec = Executors.newFixedThreadPool(6);
//        try {
//            List<Callable<HashMap<String, String>>> tasks = new ArrayList<Callable<HashMap<String, String>>>();
//            for (final String cpuName : cpuNames) {
//                Callable<HashMap<String, String>> c = new Callable<HashMap<String, String>>() {
//                    public HashMap<String, String> call(){
//                        openPage(cpuName);
//                        try {
//                            WebDriverWait wait = new WebDriverWait(driver, 5);
//                            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/center/div[7]/div[1]/table[1]/tbody/tr[2]/td[1]")));
//
//                        }catch (TimeoutException e){
//                            System.out.println("Timeout for " + cpuName);
//                        }
//                        crawlResult = crawlTarget(cpuName, crawlResult);
//                        return crawlResult;
//                    }
//                };
//                tasks.add(c);
//            }
//            List<Future<HashMap<String, String>>> results = exec.invokeAll(tasks);
//            for (Future<HashMap<String, String>> fr : results) {
//                for(Map.Entry<String, String> entry: fr.get().entrySet()) {
//                    crawlResult.put(entry.getKey(), entry.getValue());
//                }
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        } finally {
//            exec.shutdown();
//        }
//        return crawlResult;
    }

    private void initiateDriver(){
        driver = DriverUtil.initiateDriver(driver);
    }

    protected abstract void openPage(String cpuName);

    protected abstract HashMap<String, String> crawlTarget(String cpuName, HashMap<String, String> crawlResult);


}
