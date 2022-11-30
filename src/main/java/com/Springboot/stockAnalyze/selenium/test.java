package com.Springboot.stockAnalyze.selenium;

import com.Springboot.stockAnalyze.DO.StockDetail;
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
        System.setProperty("webdriver.chrome.driver", "/Users/shiemingshiou/Documents/chromeDriver/chromedriver");
        WebDriver driver = new ChromeDriver(); // googleChrome
        try {


            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            // 到Google首頁
            driver.get("https://tw.stock.yahoo.com/");

            // 輸入股票代號
            String stockNumber = "2495";
            chooseStock(driver, stockNumber);


            // 取得股票數據
            StockInfo stockInfo = new StockInfo();
            getStockInfo(driver, stockInfo);

            // 取得股價明細及成交量
            List<StockDetail> detailList = new ArrayList<>();
            boolean isfindLastInfo = false;
            driver.findElement(By.xpath("//*[@id=\"main-1-QuoteTabs-Proxy\"]/nav/div/div/div[3]/a/span/span")).click();
            WebElement ul = driver.findElement(By.xpath("//*[@id=\"qsp-ts-price-by-time\"]/div[1]/div[2]/div[1]/div/div[2]/ul"));
            List<WebElement> list = null;
            while (!isfindLastInfo){
                list =ul.findElements(By.xpath("li"));
                for (WebElement we : list){
                    String time = we.findElement(By.xpath("div/div[1]")).getText();
                    if (time.equals("09:00:05")){
                        isfindLastInfo = true;
                    }
                }
                // 進行載入更多明細
                try {
                    driver.findElement(By.xpath("//*[@id=\"qsp-ts-price-by-time\"]/div[1]/div[2]/div[2]/button/div/span")).click();
                }catch (Exception e ){
                    System.out.println("找不到載入更多明細按鍵");
                }
            }

            for(WebElement we : list){
                String time = we.findElement(By.xpath("div/div[1]")).getText();
                String price = we.findElement(By.xpath("div/div[2]/span")).getText();
                String upDown = we.findElement(By.xpath("div/div[3]/span")).getText();
                String tradingVolume = we.findElement(By.xpath("div/div[4]/span")).getText();

                StockDetail detail = new StockDetail();
                detail.setTime(time);
                detail.setPrice(price);
                detail.setUpAndDown(upDown);
                detail.setTradingVolume(tradingVolume);
                detailList.add(detail);
            }


            //*[@id="qsp-ts-price-by-time"]/div[1]/div[2]/div/div/div[2]/ul/li[1]/div/div[4]/span
            //*[@id="qsp-ts-price-by-time"]/div[1]/div[2]/div/div/div[2]/ul/li[1]/div/div[3]/span
            //*[@id="qsp-ts-price-by-time"]/div[1]/div[2]/div/div/div[2]/ul/li[1]/div/div[2]/span
            //*[@id="qsp-ts-price-by-time"]/div[1]/div[2]/div[1]/div/div[2]/ul/li[1]/div/div[1]
            //*[@id="qsp-ts-price-by-time"]/div[1]/div[2]/div[1]/div/div[2]/ul/li[1]
            //09:00:05
            //*[@id="qsp-ts-price-by-time"]/div[1]/div[2]/div[2]/button/div/span
            //*[@id="qsp-ts-price-by-time"]/div[1]/div[2]/div[2]/button/div/span


            System.out.println(detailList.toString());
            System.out.println(stockInfo.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.close();
            driver.quit();
        }


    }

    private static void chooseStock(WebDriver driver, String stockNumber) {
        WebElement we;
        we = driver.findElement(By.xpath("//*[@id=\"ssb-search-input\"]"));
        we.sendKeys(stockNumber);

        // 點選股票
        we = driver.findElement(By.xpath("//*[@id=\"ssb-suggestion-list\"]/div/ul/li[1]/a"));
        we.click();
    }

    private static void getStockInfo(WebDriver driver, StockInfo stockInfo) {
        WebElement we;
        we = driver.findElement(By.xpath("//*[@id=\"main-0-QuoteHeader-Proxy\"]/div/div[1]/h1"));
        stockInfo.setName(we.getText());

        we = driver.findElement(By.xpath("//*[@id=\"main-0-QuoteHeader-Proxy\"]/div/div[1]/span"));
        stockInfo.setNumber(we.getText());

        we = driver.findElement(By.xpath("//*[@id=\"main-0-QuoteHeader-Proxy\"]/div/div[2]/div[1]/div/span[1]"));
        stockInfo.setPrice(we.getText());
    }

}
