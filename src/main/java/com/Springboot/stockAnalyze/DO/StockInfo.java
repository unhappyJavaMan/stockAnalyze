package com.Springboot.stockAnalyze.DO;

import java.util.ArrayList;
import java.util.List;

public class StockInfo {
    private String name;
    private String number;
    private String price;
    private List<StockDetail> detailList;

    public StockInfo() {
        this.detailList = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "StockInfo{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", price='" + price + '\'' +
                ", detailList=" + detailList +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<StockDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<StockDetail> detailList) {
        this.detailList = detailList;
    }

    public static class StockDetail {
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

}
