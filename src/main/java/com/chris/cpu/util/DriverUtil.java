package com.chris.cpu.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverUtil {

    private static final DesiredCapabilities caps = new DesiredCapabilities();

    public static WebDriver initiateDriver(WebDriver driver){
        caps.setJavascriptEnabled(true);
        //FIXME This is my local phantomjs path
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/usr/local/bin/phantomjs");
        driver = new PhantomJSDriver(caps);
        return driver;
    }

}


