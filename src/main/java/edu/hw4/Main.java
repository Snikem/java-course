package edu.hw4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {

    }
    public static void main(String[] args) {
        List<Animal> list1 = new ArrayList<>();
        list1.add(new Animal("Petrov Oleg Anatol'evich ", Animal.Type.CAT, Animal.Sex.M,9,110,70,true));
        list1.add(new Animal("Skorohodova Natasha lion ", Animal.Type.CAT, Animal.Sex.F,4,101,60,false));
        list1.add(new Animal("fedor", Animal.Type.FISH, Animal.Sex.M,6,5,5,false));
        list1.add(new Animal("Yula", Animal.Type.FISH, Animal.Sex.F,10,10,9,false));
        list1.add(new Animal("Vova", Animal.Type.DOG, Animal.Sex.M,20,32,38,false));
        list1.add(new Animal("Nikita", Animal.Type.DOG, Animal.Sex.M,12,40,42,false));
        list1.add(new Animal("Vera gura b b b b", Animal.Type.CAT, Animal.Sex.F,13,9,9,false));
        list1.add(new Animal("Roma", Animal.Type.BIRD, Animal.Sex.M,5,5,6,false));
        list1.add(new Animal("Rick", Animal.Type.SPIDER, Animal.Sex.M,8,1,1,false));
        list1.add(new Animal("Marta", Animal.Type.SPIDER, Animal.Sex.F,20,2,1,true));
        list1.add(new Animal("Dima", Animal.Type.BIRD, Animal.Sex.M,2,3,3,false));
        list1.add(new Animal("Misha", Animal.Type.CAT, Animal.Sex.F,20,122,90,true));
        List<Animal> list2 = new ArrayList<>();
        list2.add(new Animal("fedor1", Animal.Type.FISH, Animal.Sex.M,6,5,5,false));
        list2.add(new Animal("Yula1", Animal.Type.FISH, Animal.Sex.F,10,15,21,false));
        List<Animal> list3 = new ArrayList<>();
        list3.add(new Animal("fedor2", Animal.Type.FISH, Animal.Sex.M,6,5,3,false));
        list3.add(new Animal("Yula2", Animal.Type.FISH, Animal.Sex.F,10,15,10,false));
        List<List<Animal>> listList = new ArrayList<>();
        listList.add(list1);
        listList.add(list2);
        listList.add(list3);
//        LOGGER.info(list.toString());
//        Animal.sortAnimalsByHightASC(list);
//        LOGGER.info(Animal.sortAnimalsByHightASC(list));
//        LOGGER.info(Animal.sortAnimalsByWeightESC(list,4));
//        LOGGER.info(Animal.numberOfAnimalsOfEachSpecies(list));
        // LOGGER.info(Animal.longestName(list));
       // LOGGER.info(Animal.WhomMore(list));
        //LOGGER.info(Animal.theHeaviestAnimalEach(list));
       // LOGGER.info(Animal.olderAnimal(list,3));
       // LOGGER.info(Animal.heaviestAnimalDowntToKey(list,10));
       // LOGGER.info(Animal.numberOfLegs(list));
       // LOGGER.info(Animal.notMatchTheNumberOfPaws(list));
       // LOGGER.info(Animal.BitesAndHigherThat100(list));
      //  LOGGER.info(Animal.numberOfWightMoreHeight(list));
        // LOGGER.info(Animal.nameOver2Words(list));
     //   LOGGER.info(Animal.hasDogLessHeightThen(list,40));
      //  LOGGER.info(Animal.weightEachTypeWith(list,10,40));
       // LOGGER.info(Animal.sortByTypeBySexByName(list));
       // LOGGER.info(Animal.isSpiderBitesMoreThenDogs(list));
        LOGGER.info(Animal.heaviestFishFromLists(listList));



    }

}
