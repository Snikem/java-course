package edu.hw3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class TestTask3 {
    @Test
    @DisplayName("Тест freqDict")
    void TestFreqDict() {
        List<String> t1 = new ArrayList<>(Arrays.asList("a", "bb", "a", "bb"));
        List<String> t2 = new ArrayList<>(Arrays.asList("this", "and", "that", "and"));
        List<String> t3 = new ArrayList<>(Arrays.asList("код", "код", "код", "bug"));
        List<Integer> t4 = new ArrayList<>(Arrays.asList(1, 1, 2, 2));
        Map<String,Integer> as1 = new HashMap<String,Integer>();
        as1.put("bb", 2);
        as1.put("a", 2);
        Map<String,Integer> as2 = new HashMap<String,Integer>();
        as2.put("that",1);
        as2.put("and",2);
        as2.put("this",1);
        Map<String,Integer> as3 = new HashMap<String,Integer>();
        as3.put("код",3);
        as3.put("bug",1);
        Map<Integer,Integer> as4 = new HashMap<Integer,Integer>();
        as4.put(1,2);
        as4.put(2,2);
        assertThat(Task3.freqDict(t1)).isEqualTo(as1);
        assertThat(Task3.freqDict(t2)).isEqualTo(as2);
        assertThat(Task3.freqDict(t3)).isEqualTo(as3);
        assertThat(Task3.freqDict(t4)).isEqualTo(as4);

    }
}
