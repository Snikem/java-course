package edu.hw4;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static java.util.Collections.reverseOrder;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;

@SuppressWarnings({"MagicNumber"})
public record Animal(
    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    boolean bites
) {
    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Sex {
        M, F
    }

    private final static Logger LOGGER = LogManager.getLogger();

    public int paws() {
        return switch (type) {
            case CAT, DOG -> 4;
            case BIRD -> 2;
            case FISH -> 0;
            case SPIDER -> 8;
        };
    }

    public static List<Animal> sortAnimalsByHightASC2(List<Animal> list) {
        Collections.sort(list, new AnimalByHightASCComparator());
        return list;
    }

    public static List<Animal> sortAnimalsByHightASC(List<Animal> animals) {
        return animals.stream().sorted(Comparator.comparingInt(Animal::height)).toList();
    }

    public static List<Animal> sortAnimalsByWeightESC(List<Animal> list, int firstAnimal) {
        return list.stream().sorted((a1, a2) -> reverseOrder().compare(a1.weight, a2.weight)).limit(firstAnimal)
            .toList();
    }

    public static Map<Animal.Type, Integer> numberOfAnimalsOfEachSpecies(List<Animal> list) {
        return list.stream()
            .collect(Collectors.groupingBy(Animal::type, collectingAndThen(counting(), Long::intValue)));
    }

    public static Animal longestName(List<Animal> list) {
        return list.stream().max(Comparator.comparingInt(a -> a.name.length())).get();
    }

    public static Animal.Sex whomMore(List<Animal> list) {
        return list.stream().collect(Collectors.groupingBy(Animal::sex, collectingAndThen(counting(), Long::intValue)))
            .entrySet().stream().max(Comparator.comparingInt(a -> a.getValue())).get().getKey();
    }

    public static Map<Animal.Type, Animal> theHeaviestAnimalEach(List<Animal> list) {
        Map<Animal.Type, Animal> result = new HashMap<>();
        for (Type t : Type.values()) {

            var temp = list.stream().filter(it -> it.type == t).max(Comparator.comparingInt(a -> a.weight));
            if (!Optional.empty().equals(temp)) {
                result.put(temp.get().type, temp.get());
            }

        }
        return result;

    }

    public static Animal olderAnimal(List<Animal> list, int k) {
        return list.stream().sorted(((o1, o2) -> reverseOrder().compare(o1.age, o2.age))).toList().get(k - 1);
    }

    public static Optional<Animal> heaviestAnimalDowntToKey(List<Animal> list, int k) {
        return list.stream().filter(it -> it.height < k)
            .sorted(((o1, o2) -> reverseOrder().compare(o1.weight, o2.weight))).findFirst();
    }

    public static Integer numberOfLegs(List<Animal> list) {
        return list.stream().reduce(0, (subtotal, elem) -> subtotal + elem.paws(), Integer::sum);
    }

    //Список животных, возраст у которых не совпадает с количеством лап -> List<Animal>
    public static List<Animal> notMatchTheNumberOfPaws(List<Animal> list) {
        return list.stream().filter(it -> it.age != it.paws()).toList();
    }
    //Список животных, которые могут укусить (bites == null или true) и рост которых превышает 100 см -> List<Animal>

    public static List<Animal> bitesAndHigherThat100(List<Animal> list) {
        return list.stream().filter(it -> it.bites && it.height > 100).toList();

    }

    //Сколько в списке животных, вес которых превышает рост -> Integer
    public static Integer numberOfWightMoreHeight(List<Animal> list) {
        return list.stream().filter(it -> it.weight > it.height).collect(Collectors.reducing(0, e -> 1, Integer::sum));
    }

    // Список животных, имена которых состоят из более чем двух слов -> List<Animal>
    public static List<Animal> nameOver2Words(List<Animal> list) {
        return list.stream().filter(it -> Arrays.stream(it.name.split(" ")).toList().size() > 2).toList();
    }

    //Есть ли в списке собака ростом более k см -> Boolean

    public static Boolean hasDogLessHeightThen(List<Animal> list, int k) {
        return list.stream().anyMatch(it -> it.type == Type.DOG && it.height > k);
    }

    //Найти суммарный вес животных каждого вида, которым от k до l лет -> Integer
    public static Map<Animal.Type, Integer> weightEachTypeWith(List<Animal> list, int k, int l) {
        return list.stream()
            .filter(animal -> animal.age() >= k && animal.age() <= l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }
    //Список животных, отсортированный по виду, затем по полу, затем по имени -> List<Integer>

    public static List<Animal> sortByTypeBySexByName(List<Animal> list) {
        return list.stream().sorted(Comparator.comparing(Animal::type).thenComparing(Animal::sex)
            .thenComparing(Animal::name)).toList();
    }
    //Правда ли, что пауки кусаются чаще, чем собаки -> Boolean (если данных для ответа недостаточно, вернуть false)

    public static Boolean isSpiderBitesMoreThenDogs(List<Animal> list) {
        double dog = (double) list.stream()
            .filter(it -> it.type() == Animal.Type.DOG && it.bites())
            .count() / list.stream().filter(it -> it.type() == Animal.Type.DOG).count();

        double spider = (double) list.stream()
            .filter(it -> it.type() == Animal.Type.SPIDER && it.bites())
            .count() / list.stream().filter(it -> it.type() == Animal.Type.SPIDER).count();

        return spider > dog;

    }

    //Найти самую тяжелую рыбку в 2-х или более списках -> Animal
    public static Animal heaviestFishFromLists(List<List<Animal>> list) {
        return list.stream().flatMap(List::stream)
            .filter(it -> it.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight)).orElse(null);
    }

}
