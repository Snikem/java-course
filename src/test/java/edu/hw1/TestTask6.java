package edu.hw1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class TestTask6 {
    @Test
    @DisplayName("Постоянная Капрекара")
    void testCountK()
    {
        int t1 = 3524;// 3
        int t2 = 6621;// 5
        int t3 = 6554;// 4
        int t4 = 1234;// 3
        int t5 = 2195;/* 9521 - 1259 = 8262
                         8622 - 2268 = 6354
                         6543 - 3456 = 3087
                         8730 - 378 = 8352
                         8532 - 2358 = 6174 5*/
        assertThat(Task6.countK(t1,0)).isEqualByComparingTo(3);
        assertThat(Task6.countK(t2,0)).isEqualByComparingTo(5);
        assertThat(Task6.countK(t3,0)).isEqualByComparingTo(4);
        assertThat(Task6.countK(t4,0)).isEqualByComparingTo(3);
        assertThat(Task6.countK(t5,0)).isEqualByComparingTo(5);


    }

}
