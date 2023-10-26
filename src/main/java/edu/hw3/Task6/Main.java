package edu.hw3.Task6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) {
        StockExchange stockExchange = new StockExchange("Московкая биржа");
        stockExchange.add(new Stock("Гаспром",1111));
        stockExchange.add(new Stock("Лукойл",111));
        stockExchange.add(new Stock("Тинькофф",111111));
        stockExchange.add(new Stock("Сбербанк",11));
        stockExchange.add(new Stock("Альфабанк",111));
        LOGGER.info(stockExchange.mostValuableStock());
        stockExchange.remove(new Stock("Тинькофф",111111));
        LOGGER.info(stockExchange.mostValuableStock());

    }
}
