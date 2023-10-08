package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask2 {
    @Test
    @DisplayName("тест функции подсчета цифр")
    void testCountDigits()
    {
        int a1 = 4666; // 4
        int a2 = 544; // 3
        int a3 = 0;// 1
        int a4 = 235235235;//9
        assertThat(Task2.countDigits(a1)).isEqualByComparingTo(4);
        assertThat(Task2.countDigits(a2)).isEqualByComparingTo(3);
        assertThat(Task2.countDigits(a3)).isEqualByComparingTo(1);
        assertThat(Task2.countDigits(a4)).isEqualByComparingTo(9);
    }

}
