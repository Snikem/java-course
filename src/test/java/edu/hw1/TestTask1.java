package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask1 {
    @Test
    @DisplayName("Тест функции minutesToSeconds")
    void TestMinutesToSeconds() {
        String t1 = "01:00"; // 1 * 60 + 0 = 60
        String t2 = "13:56";// 13 * 60 + 56 = 836
        String t3 = "10:60";//60 >= 60 -> -1
        String t4 = "100:56";//100 * 60 + 56 = 6056
        assertThat(Task1.minutesToSeconds(t1)).isEqualByComparingTo(60);
        assertThat(Task1.minutesToSeconds(t2)).isEqualByComparingTo(836);
        assertThat(Task1.minutesToSeconds(t3)).isEqualByComparingTo(-1);
        assertThat(Task1.minutesToSeconds(t4)).isEqualByComparingTo(6056);
    }
}
