package com.Springboot.stockAnalyze.selenium;

import com.Springboot.stockAnalyze.DO.StockInfo;
import com.Springboot.stockAnalyze.selenium.Step.ClosePage;
import com.Springboot.stockAnalyze.selenium.Step.OpenPage;
import com.Springboot.stockAnalyze.selenium.Step.StockDetail;
import org.openqa.selenium.WebDriver;

public class GetStockDetail {

    public static StockInfo getStockInfo(String stockNumber, String timestamp){
        WebDriver driver = null;
        try {
            driver = OpenPage.getPageDricer();
            StockInfo detail = StockDetail.getDetail(driver, stockNumber,timestamp);
            return detail;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ClosePage.close(driver);
        }
        return null;

    }
}
