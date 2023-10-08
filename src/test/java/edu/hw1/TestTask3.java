package edu.hw1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class TestTask3 {
    @Test
    @DisplayName("Тест вложения массива в другой")
    void testIsNestable()
    {
        int[] a1 = new int[]{1, 2, 3, 4};//true
        int[] a2 = new int[]{0, 6};

        int[] b1 = new int[]{3, 1};//true
        int[] b2 = new int[]{4, 0};

        int[] c1 = new int[]{9, 9, 8};//false
        int[] c2 = new int[]{8, 9};

        int[] d1 = new int[]{1, 2, 3, 4};//false
        int[] d2 = new int[]{2, 3};

        int[] e1 = new int[]{5, 7, 9};//true
        int[] e2 = new int[]{2, 3, 10, 11, 12};
        assertThat(Task3.isNestable(a1,a2)).isTrue();
        assertThat(Task3.isNestable(b1,b2)).isTrue();
        assertThat(Task3.isNestable(c1,c2)).isFalse();
        assertThat(Task3.isNestable(d1,d2)).isFalse();
        assertThat(Task3.isNestable(e1,e2)).isTrue();
    }
}
