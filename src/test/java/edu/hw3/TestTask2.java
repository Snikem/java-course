package edu.hw3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class TestTask2 {
    @Test
    @DisplayName("Тест clusterize")
    void TestClusterize() {
        String t1 = "()()()";
        String t2 = "((()))";
        String t3 = "((()))(())()()(()())";
        String t4 = "((())())(()(()()))";
        List<String> as1 = new ArrayList<>(Arrays.asList("()", "()", "()"));
        List<String> as2 = new ArrayList<>(Arrays.asList("((()))"));
        List<String> as3 = new ArrayList<>(Arrays.asList("((()))", "(())", "()", "()", "(()())"));
        List<String> as4 = new ArrayList<>(Arrays.asList("((())())", "(()(()()))"));
        assertThat(Task2.clusterize(t1)).isEqualTo(as1);
        assertThat(Task2.clusterize(t2)).isEqualTo(as2);
        assertThat(Task2.clusterize(t3)).isEqualTo(as3);
        assertThat(Task2.clusterize(t4)).isEqualTo(as4);


    }
}
