package edu.hw10.task1.Classes;

import edu.hw10.task1.Anot.Max;
import edu.hw10.task1.Anot.Min;
import edu.hw10.task1.Anot.NotNull;

public class MyClassWithAnnots {
    private int age;
    private String name;

    public MyClassWithAnnots(@Min(3) @Max(78) int age, @NotNull String name) {
        this.age = age;
        this.name = name;
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    public static MyClassWithAnnots create() {
        return new MyClassWithAnnots(20, "Anton");
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
