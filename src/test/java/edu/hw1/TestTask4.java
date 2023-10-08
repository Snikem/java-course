package edu.hw1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class TestTask4 {
    @Test
    @DisplayName("Ремонт строки")
    void testFixString()
    {
        String str1 = "оПомигети псаривьтс ртко!и";//Помогите исправить строки!
        String str2 = "123456";//
        String str3 = "hTsii  s aimex dpus rtni.g";//This is a mixed up string.
        String str4 = "badce";//abcde
        assertThat(Task4.fixString(str1)).isEqualTo("Помогите исправить строки!");
        assertThat(Task4.fixString(str2)).isEqualTo("214365");
        assertThat(Task4.fixString(str3)).isEqualTo("This is a mixed up string.");
        assertThat(Task4.fixString(str4)).isEqualTo("abcde");
    }

}
