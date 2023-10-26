package edu.hw3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class TestTask4 {
    @Test
    @DisplayName("Тест convertToRoman")
    void TestConvertToRoman() {
        int t1 = 2;
        int t2 = 12;
        int t3 =  16;
        int t4 = 213;//CCXIII
        assertThat(Task4.convertToRoman(t1)).isEqualTo("II");
        assertThat(Task4.convertToRoman(t2)).isEqualTo("XII");
        assertThat(Task4.convertToRoman(t3)).isEqualTo("XVI");
        assertThat(Task4.convertToRoman(t4)).isEqualTo("CCXIII");

    }
}
