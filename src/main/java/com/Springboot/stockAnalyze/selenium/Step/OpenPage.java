package com.Springboot.stockAnalyze.selenium.Step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OpenPage {
    public static WebDriver getPageDricer() {
        System.setProperty("webdriver.chrome.driver", "/Users/shiemingshiou/Documents/chromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver(); // googleChrome


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://tw.stock.yahoo.com/");
        return driver;
    }
}
