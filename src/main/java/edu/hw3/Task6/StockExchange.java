package edu.hw3.Task6;

import java.util.PriorityQueue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StockExchange implements StockMarket {
    private final static Logger LOGGER = LogManager.getLogger();
    PriorityQueue<Stock> allStocks;
    String nameExchange;

    public StockExchange(String name) {
        nameExchange = name;
        allStocks = new PriorityQueue<Stock>();
    }

    @Override
    public void add(Stock stock) {
        allStocks.offer(stock);

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
