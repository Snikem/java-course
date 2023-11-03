package edu.project2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void main(String[] args) {
//        List<List<Integer>> t = new ArrayList<List<Integer>>();
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(4);
//        list2.add(5);
//        list2.add(6);
//        List<Integer> list3 = new ArrayList<>();
//        list3.add(7);
//        list3.add(8);
//        list3.add(9);
//        t.add(list);
//        t.add(list2);
//        t.add(list3);
//        LOGGER.info(t);
//        t.get(2).set(0,20);
//        LOGGER.info(t);
       Maze maze = new Maze(50,50);
       maze.printMaze2();
       List<Coordinates> list = new ArrayList<>();
        list.add(new Coordinates(-1,0));
       list.add(new Coordinates(0,0));
        List<Coordinates> list2 = maze.solve(list);
        maze.printSolveMaze(list2);
        LOGGER.info(list2);
    }
}
