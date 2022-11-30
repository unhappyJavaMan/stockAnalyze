package com.Springboot.stockAnalyze.DO;

public class StockDetail {
    private String time;
    private String tradingVolume;
    private String price;
    private String upAndDown;

    @Override
    public String toString() {
        return "StockDetail{" +
                "time='" + time + '\'' +
                ", tradingVolume='" + tradingVolume + '\'' +
                ", price='" + price + '\'' +
                ", upAndDown='" + upAndDown + '\'' +
                '}';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTradingVolume() {
        return tradingVolume;
    }

    public void setTradingVolume(String tradingVolume) {
        this.tradingVolume = tradingVolume;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUpAndDown() {
        return upAndDown;
    }

    public void setUpAndDown(String upAndDown) {
        this.upAndDown = upAndDown;
    }
}
