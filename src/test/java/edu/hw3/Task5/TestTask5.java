package edu.hw3.Task5;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class TestTask5 {
    @Test
    @DisplayName("Тест parseContacts")
    void TestParseContacts() {
        List<String> list1 = new ArrayList<>(Arrays.asList( "John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"));
        List<String> list2 = new ArrayList<>(Arrays.asList("Paul Erdos", "Leonhard Euler", "Carl Gauss"));
        List<String> list3 = new ArrayList<>(Arrays.asList("Paul", "Leonhard Euler", "Carl"));
        List<String> list4 = new ArrayList<>();
        List<Contact> as2 = new ArrayList<>();
        as2.add(new Contact("Carl","Gauss"));
        as2.add(new Contact( "Leonhard","Euler"));
        as2.add(new Contact("Paul","Erdos"));
        List<Contact> as1 = new ArrayList<>();
        as1.add(new Contact("Thomas","Aquinas"));
        as1.add(new Contact("Rene","Descartes"));
        as1.add(new Contact("David","Hume"));
        as1.add(new Contact("John","Locke"));
        List<Contact> as3 = new ArrayList<>();
        as3.add(new Contact("Paul",""));
        as3.add(new Contact( "Leonhard","Euler"));
        as3.add(new Contact("Carl",""));
        List<Contact> as4 = new ArrayList<>();
        assertThat(Task5.parseContacts(list1,"ASC")).isEqualTo(as1);
        assertThat(Task5.parseContacts(list2,"DESC")).isEqualTo(as2);
        assertThat(Task5.parseContacts(list3,"DESC")).isEqualTo(as3);
        assertThat(Task5.parseContacts(list4,"ASC")).isEqualTo(as4);
        assertThat(Task5.parseContacts(null,"ASC")).isEqualTo(as4);

    }
}
