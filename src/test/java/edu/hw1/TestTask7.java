package edu.hw1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class TestTask7 {
    @Test
    @DisplayName(" Циклический битовый сдвиг влево")
    void testRotateLeft()
    {
        int t1 = 16;//сдвиг на 1 ответ = 1  // 10000 -> 00001
        int t2 = 17;//сдвиг на 2 ответ = 6 // 10001 -> 00110
        int t3 = 25;//сдвиг на 3 ответ 14 // 11001 -> 01110
        int t4 = 20;//сдвиг на 2 ответ 18 // 10100 -> 10010
        assertThat(Task7.rotateLeft(t1,1)).isEqualByComparingTo(1);
        assertThat(Task7.rotateLeft(t2,2)).isEqualByComparingTo(6);
        assertThat(Task7.rotateLeft(t3,3)).isEqualByComparingTo(14);
        assertThat(Task7.rotateLeft(t4,2)).isEqualByComparingTo(18);
    }
    @Test
    @DisplayName(" Циклический битовый сдвиг вправо")
    void testRotateRight()
    {
        int t1 = 8;//сдвиг на 1 ответ = 4  // 1000 -> 0100
        int t2 = 17;//сдвиг на 2 ответ = 12 // 10001 -> 01100
        int t3 = 25;//сдвиг на 3 ответ 7 // 11001 -> 00111
        int t4 = 20;//сдвиг на 2 ответ 5 // 10100 -> 00101
        assertThat(Task7.rotateRight(t1,1)).isEqualByComparingTo(4);
        assertThat(Task7.rotateRight(t2,2)).isEqualByComparingTo(12);
        assertThat(Task7.rotateRight(t3,3)).isEqualByComparingTo(7);
        assertThat(Task7.rotateRight(t4,2)).isEqualByComparingTo(5);
    }
}
