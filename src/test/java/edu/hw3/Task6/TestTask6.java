package edu.hw3.Task6;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class TestTask6 {
    @Test
    @DisplayName("Тест stockExchange")
    void TeststockExchange() {
        StockExchange stockExchange = new StockExchange("Московкая биржа");
        stockExchange.add(new Stock("Газпром",1111));
        stockExchange.add(new Stock("Лукойл",11));
        stockExchange.add(new Stock("Тинькофф",111111));
        stockExchange.add(new Stock("Сбербанк",1));
        stockExchange.add(new Stock("Альфабанк",111));
        assertThat(stockExchange.mostValuableStock()).isEqualTo(new Stock("Тинькофф",111111));
        stockExchange.remove(new Stock("Тинькофф",111111));
        assertThat(stockExchange.mostValuableStock()).isEqualTo(new Stock("Газпром",1111));
        stockExchange.remove(new Stock("Газпром",1111));
        assertThat(stockExchange.mostValuableStock()).isEqualTo(new Stock("Альфабанк",111));
        stockExchange.remove(new Stock("Альфабанк",111));
        assertThat(stockExchange.mostValuableStock()).isEqualTo(new Stock("Лукойл",11));



    }
}
