package edu.hw3.Task6;

import org.jetbrains.annotations.NotNull;

public record Stock(String name, int price) implements Comparable<Stock> {
    @Override
    public int compareTo(@NotNull Stock o) {
        return Integer.compare(o.price,this.price);
    }
}
