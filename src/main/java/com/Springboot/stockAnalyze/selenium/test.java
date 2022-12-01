package com.Springboot.stockAnalyze.selenium;

import com.Springboot.stockAnalyze.DO.StockInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class test {

    public static void main(String[] args) {
        StockInfo stockInfo = GetStockDetail.getStockInfo("2495", null);
        System.out.println(stockInfo.toString());

    }

}
