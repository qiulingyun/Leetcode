package QLY.Leetcode.design;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/stock-price-fluctuation/
 * 2034. 股票价格波动
 * 给你一支股票价格的数据流。数据流中每一条记录包含一个 时间戳 和该时间点股票对应的 价格 。
 * 不巧的是，由于股票市场内在的波动性，股票价格记录可能不是按时间顺序到来的。某些情况下，有的记录可能是错的。如果两个有相同时间戳的记录出现在数据流中，前一条记录视为错误记录，后出现的记录 更正 前一条错误的记录。
 * <p>
 * 请你设计一个算法，实现：
 * 更新 股票在某一时间戳的股票价格，如果有之前同一时间戳的价格，这一操作将 更正 之前的错误价格。
 * 找到当前记录里 最新股票价格 。最新股票价格 定义为时间戳最晚的股票价格。
 * 找到当前记录里股票的 最高价格 。
 * 找到当前记录里股票的 最低价格 。
 * 请你实现 StockPrice 类：
 * <p>
 * StockPrice() 初始化对象，当前无股票价格记录。
 * void update(int timestamp, int price) 在时间点 timestamp 更新股票价格为 price 。
 * int current() 返回股票 最新价格 。
 * int maximum() 返回股票 最高价格 。
 * int minimum() 返回股票 最低价格 。
 */
public class StockPriceFluctuation {

    private int currTime;
    private HashMap<Integer, Integer> priceMap;
    private TreeMap<Integer, Integer> priceOccurenceMap;

    public StockPriceFluctuation() {
        this.currTime = 0;
        this.priceMap = new HashMap<>();
        this.priceOccurenceMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        currTime = Math.max(currTime, timestamp);
        if (priceMap.containsKey(timestamp)) {
            int prevPrice = priceMap.get(timestamp);
            int prevTimes = priceOccurenceMap.getOrDefault(prevPrice, 0);
            if (prevTimes == 1)
                priceOccurenceMap.remove(prevPrice);
            else
                priceOccurenceMap.put(prevPrice, prevTimes - 1);

        }

        priceMap.put(timestamp, price);
        priceOccurenceMap.put(price, priceOccurenceMap.getOrDefault(price, 0) + 1);

    }

    public int current() {
        return priceMap.get(currTime);
    }

    public int maximum() {
        return priceOccurenceMap.lastKey();
    }

    public int minimum() {
        return priceOccurenceMap.firstKey();
    }
}
