package com.Springboot.stockAnalyze.selenium.Step;

import org.openqa.selenium.WebDriver;

public class ClosePage {

    public static void close(WebDriver driver){
        driver.close();
        driver.quit();
    }
}
