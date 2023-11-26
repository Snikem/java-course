package edu.hw2.hw7;

import edu.hw7.Task1;
import edu.hw7.Task2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestTask2 {
    @Test
    @DisplayName("Тест факториал")
    void TestMath() {

            assertThat(Task2.factorial(5)).isEqualTo(120);
            assertThat(Task2.factorial(10)).isEqualTo(3628800);
            assertThat(Task2.factorial(3)).isEqualTo(6);




    }
}
