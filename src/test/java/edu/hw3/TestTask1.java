package edu.hw3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class TestTask1 {
    @Test
    @DisplayName("Тест atbash")
    void TestAtbash() {
        String t1 = "Hello world!";
        String t2 = "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler";
        String t3 = "Русские буквы не пишутся az";
        assertThat(Task1.atbash(t1)).isEqualTo("Svool dliow!");
        assertThat(Task1.atbash(t2)).isEqualTo("Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi");
        assertThat(Task1.atbash(t3)).isEqualTo("Русские буквы не пишутся za");


    }

}
