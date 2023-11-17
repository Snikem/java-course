package edu.hw3;
import edu.hw3.Task8.BackwardIterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class TestTask8 {
    @Test
    @DisplayName("Тест BackwardIterator")
    void TestBackwardIterator() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        BackwardIterator it = new BackwardIterator<>(list);
        int[] a = new int[]{6,5,4,3,2,1};
        int i = 0;
        while(it.hasNext())
        {
            assertThat(it.next()).isEqualTo(a[i]);
                i++;

        }

    }
}
