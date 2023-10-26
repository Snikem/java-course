package edu.hw3;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Comparator;
import java.util.TreeMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class TestTask7 {
    @Test
    @DisplayName("Тест TreeMapNull")
    void TestTreeMapNull() {
        TreeMap<String, String> tree = new TreeMap<String, String>(Comparator.nullsFirst(Comparator.naturalOrder()));
        tree.put(null,"asd");
        assertThat(tree.containsKey(null)).isTrue();

    }
}
