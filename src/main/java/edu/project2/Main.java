package edu.project2;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
@SuppressWarnings("MagicNumber")
public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void main(String[] args) {
        Maze maze = new Maze(2, 2);
        maze.printMaze2();
        List<Coordinates> list2 = maze.solve();
        maze.printSolveMaze(list2);
    }
}
