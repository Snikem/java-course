package edu.hw1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class TestTask5 {
    @Test
    @DisplayName("Особый палиндром")
    void testIsPalindromeDescendant()
    {
        int t1 = 11211230;// true 11211230 -> 2333 -> 56 -> 11
        int t2 = 13001120;//  true  13001120 -> 4022 ➞ 44
        int t3 = 23336014; // true  23336014 -> 5665
        int t4 = 11; //  true
        int t5 = 12345;// 12345 не палиндром и нет потомков false
        int t6 = 123712;// 123712 -> 3103 -> 43 false
        int t7 = 123812;// 123812 -> 3113 true

        assertThat(Task5.isPalindromeDescendant(t1)).isTrue();
        assertThat(Task5.isPalindromeDescendant(t2)).isTrue();
        assertThat(Task5.isPalindromeDescendant(t3)).isTrue();
        assertThat(Task5.isPalindromeDescendant(t4)).isTrue();
        assertThat(Task5.isPalindromeDescendant(t5)).isFalse();
        assertThat(Task5.isPalindromeDescendant(t6)).isFalse();
        assertThat(Task5.isPalindromeDescendant(t7)).isTrue();

    }
}
