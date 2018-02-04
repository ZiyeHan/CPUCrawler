package com.chris.cpu.common;

public class PageConstants {

    public static final String GEEKBENCH_DESKTOP = "https://browser.geekbench.com/processor-benchmarks";
    public static final String GEEKBENCH_MOBILE = "https://browser.geekbench.com/android-benchmarks";

    public static final String DATE_DESKTOP_PREFIX = "https://www.cpubenchmark.net/cpu.php?cpu=";
    public static final String DATE_MOBILE_PREFIX = "https://www.notebookcheck.net/";

    public static final String DESKTOP_GEEKBENCH_CPUS_LOCATOR = "//*[@id=\"pc\"]/tbody/tr";
    public static final String MOBILE_GEEKBENCH_CPUS_LOCATOR = "//*[@id=\"android\"]/tbody/tr";

    public static final String DESKTOP_RELEASE_DATE_LOCATOR = "/html/body/center/div[7]/div[1]/table[1]/tbody/tr[2]/td[1]";

    //Reminder: XPath index starts with 1 not 0
    public static final String MOBILE_RELEASE_DATE_REAL_PAGE_LOCATOR = "/html/body/div/p[3]/a";
    public static final String MOBILE_RELEASE_DATE_LOCATOR_EN = "//td[contains(text(), 'Announcement Date')]/following-sibling::td"; //English
    public static final String MOBILE_RELEASE_DATE_LOCATOR_DE = "//td[contains(text(), 'Vorgestellt am')]/following-sibling::td"; //German

}






