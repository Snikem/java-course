package edu.hw3.Task6;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class StockExchange implements StockMarket{
    PriorityQueue<Stock> allStocks;
    String nameExchange;
    public StockExchange(String name) {
        nameExchange = name;
        allStocks = new PriorityQueue<Stock>();
    }

    @Override
    public void add(Stock stock) {
        allStocks.add(stock);

    }

    @Override
    public void remove(Stock stock) {
        allStocks.remove(stock);

    }

    @Override
    public Stock mostValuableStock() {
        return allStocks.peek();
    }
}
