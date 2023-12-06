package edu.project2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings({"MagicNumber", "CyclomaticComplexity",
    "ReturnCount", "RegexpSinglelineJava", "MultipleStringLiterals"})
public class Maze {
    private int width;
    private int height;
    private List<List<Boolean>> hasRightWall;
    private List<List<Boolean>> hasDownWall;
    private List<Integer> setsElem;
    private int counter = 1;
    private final int empty = 0;
    private List<Boolean> emptyArray;
    private final static Logger LOGGER = LogManager.getLogger();

    public void createEmptyMaze() {
        hasRightWall = new ArrayList<List<Boolean>>(height);
        hasDownWall = new ArrayList<List<Boolean>>(height);
        for (int i = 0; i < height; i++) {
            emptyArray = new ArrayList<>(width);
            for (int j = 0; j < width; j++) {
                emptyArray.add(false);
            }
            hasDownWall.add(emptyArray);
            emptyArray = new ArrayList<>(width);
            for (int j = 0; j < width; j++) {
                emptyArray.add(false);
            }
            hasRightWall.add(emptyArray);
        }
        setsElem = new ArrayList<>(width);

    }

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
        createEmptyMaze();
        if (width == 0 || height == 0) {
            LOGGER.info("maze cant be generate");
        } else {
            generateMaze();
        }


    }

    private void fillEmptyFirst() {
        for (int i = 0; i < width; i++) {
            setsElem.add(empty);
        }
    }

    private void initUniqueSets() {
        for (int i = 0; i < width; i++) {
            if (setsElem.get(i) == empty) {
                setsElem.set(i, counter);
                counter++;
            }
        }
    }

    private Boolean getRandomBoolean() {
        Random random = new Random();
        int a = random.nextInt(0, 10);
        if (a > 6) {
            return true;
        }
        return false;
    }

    public void mergeSet(int index, int elem) {
        int mutableSet = setsElem.get(index + 1);
        for (int j = 0; j < width; j++) {
            /* Проверка ячеек на одно множество */
            if (setsElem.get(j) == mutableSet) {
                /* Объединение ячейки в множество */
                setsElem.set(j, elem);
            }
        }
    }

    private void addingVerticalWalls(int j) {
        for (int i = 0; i < width - 1; i++) {
            /* Ставим стенку или нет */
            boolean choise = getRandomBoolean();
            /* Проверка условия для предотовращения зацикливания */
            if (choise || Objects.equals(setsElem.get(i), setsElem.get(i + 1))) {
                hasRightWall.get(j).set(i, true);
            } else {
                /* Объединение ячеек в одно множество */
                mergeSet(i, setsElem.get(i));
            }
        }
        /* Добавление правой стенки в последней ячейки */
        hasRightWall.get(j).set(width - 1, true);
    }

    public void addingHorizontalWalls(int row) {
        for (int i = 0; i < width; i++) {
            /* Ставим стенку или нет */
            boolean choise = getRandomBoolean();
            /* Проверка, что множество имеет более одной ячейки (это предовратит замкнутые области  */
            if (calculateUniqueSet(setsElem.get(i)) != 1 && choise) {
                /* Ставим горизонтальную стенку */
                hasDownWall.get(row).set(i, true);
            }
        }
    }

    /* Подсчет ячеек, которые содержаться в уникальном множестве */
    private int calculateUniqueSet(int element) {
        int countUniqSet = 0;
        for (int i = 0; i < width; i++) {
            if (setsElem.get(i) == element) {
                countUniqSet++;
            }
        }
        return countUniqSet;
    }

    /* Проверка условие 4.1 и 4.2 */
    private void checkedHorizontalWalls(int j) {
        for (int i = 0; i < width; i++) {
            if (calculateHorizontalWalls(setsElem.get(i), j) == 0) {
                hasDownWall.get(j).set(i, false);
            }
        }
    }

    /* Подсчет горизонтальных стен у ячеек уникального множества */
    int calculateHorizontalWalls(int element, int j) {
        int countHorizontalWalls = 0;
        for (int i = 0; i < width; i++) {
            if (setsElem.get(i) == element && !hasDownWall.get(j).get(i)) {
                countHorizontalWalls++;
            }
        }
        return countHorizontalWalls;
    }

    private void preparatingNewLine(int row) {
        for (int i = 0; i < width; i++) {
            if (hasDownWall.get(row).get(i)) {
                /* Присваиваем ячейки пустое множество */
                setsElem.set(i, empty);
            }
        }
    }

    private void addingEndLine() {
        initUniqueSets();
        addingVerticalWalls(height - 1);
        checkedEndLine();
    }

    /* Проверка условий на добавление последней строки */
    private void checkedEndLine() {
        for (int i = 0; i < width - 1; i++) {
            /* Проверка условия пункта 5.2.1 */
            if (setsElem.get(i) != setsElem.get(i + 1)) {
                /* Убираем вертикальную стенку */
                hasRightWall.get(height - 1).set(i, false);
                /* Объединяем множества */
                mergeSet(i, setsElem.get(i));
            }
            /* Добавляем горизонтальные стенки */
            hasDownWall.get(height - 1).set(i, true);
        }
        /* Добавляем горизонтальную стенку в последней ячейке */
        // hasDownWall.get(height - 1).set(width - 1,true);
    }

    private void generateMaze() {
        fillEmptyFirst();
        for (int j = 0; j < height - 1; j++) {
            /* Шаг 2 */
            initUniqueSets();
            /* Шаг 3 */
            addingVerticalWalls(j);
            /* Шаг 4 */
            addingHorizontalWalls(j);
            checkedHorizontalWalls(j);
            /* Шаг 5.1*/
            preparatingNewLine(j);
        }
        /* Шаг 5.2 */
        addingEndLine();

    }

    public List<Coordinates> solve() {
        List<Coordinates> list = new ArrayList<>();
        list.add(new Coordinates(-1, 0));
        list.add(new Coordinates(0, 0));
        return solveRecourse(list);
    }

    public List<Coordinates> solveRecourse(List<Coordinates> list) {
        Coordinates current = list.getLast();
        Coordinates from = list.get(list.size() - 2);
        if (current.xCols() == (width - 1) && current.yRows() == (height - 1)) {
            return list;
        }
        if (current.xCols() + 1 < width && (from.xCols() != current.xCols() + 1)
            && (!hasRightWall.get(current.yRows()).get(current.xCols()))) {
            List<Coordinates> temp = new ArrayList<Coordinates>(list);
            temp.add(new Coordinates(current.xCols() + 1, current.yRows()));
            List<Coordinates> res = solveRecourse(temp);
            if (res != null) {
                return res;

            }

        }
        if (current.xCols() - 1 >= 0 && (from.xCols() != current.xCols() - 1)
            && !hasRightWall.get(current.yRows()).get(current.xCols() - 1)) {
            List<Coordinates> temp = new ArrayList<Coordinates>(list);
            temp.add(new Coordinates(current.xCols() - 1, current.yRows()));
            List<Coordinates> res = solveRecourse(temp);
            if (res != null) {
                return res;

            }

        }
        if (current.yRows() + 1 < height && (from.yRows() != current.yRows() + 1)
            && (!hasDownWall.get(current.yRows()).get(current.xCols()))) {
            List<Coordinates> temp = new ArrayList<Coordinates>(list);
            temp.add(new Coordinates(current.xCols(), current.yRows() + 1));
            List<Coordinates> res = solveRecourse(temp);
            if (res != null) {
                return res;

            }
        }
        if (current.yRows() - 1 >= 0 && (from.yRows() != current.yRows() - 1)
            && (!hasDownWall.get(current.yRows() - 1).get(current.xCols()))) {
            List<Coordinates> temp = new ArrayList<Coordinates>(list);
            temp.add(new Coordinates(current.xCols(), current.yRows() - 1));
            List<Coordinates> res = solveRecourse(temp);
            if (res != null) {
                return res;
            }

        }
        return null;

    }

    public void printSolveMaze(List<Coordinates> list) {
        System.out.print("##");
        for (int i = 0; i < width; i++) {
            System.out.print("####");
        }
        System.out.println();

        for (int i = 0; i < height; i++) {
            if (i != 0) {
                System.out.print("##");
            } else {
                System.out.print("  ");
            }
            for (int j = 0; j < width; j++) {
                if (list.contains(new Coordinates(j, i))) {
                    if (hasRightWall.get(i).get(j)) {
                        System.out.print("<>##");

                    } else {
                        System.out.print("<>  ");
                    }
                } else {
                    if (hasRightWall.get(i).get(j)) {
                        System.out.print("  ##");

                    } else {
                        System.out.print("    ");
                    }
                }
            }
            System.out.println();
            System.out.print("##");
            for (int j = 0; j < width; j++) {
                if (hasDownWall.get(i).get(j)) {
                    System.out.print("####");
                } else {
                    System.out.print("  ##");
                }
            }
            System.out.println();
        }
    }

    public void printMaze2() {
        System.out.print("##");
        for (int i = 0; i < width; i++) {
            System.out.print("####");
        }
        System.out.println();

        for (int i = 0; i < height; i++) {
            if (i != 0) {
                System.out.print("##");
            } else {
                System.out.print("  ");
            }
            for (int j = 0; j < width; j++) {
                if (hasRightWall.get(i).get(j)) {
                    System.out.print("  ##");

                } else {
                    System.out.print("    ");
                }
            }
            System.out.println();
            System.out.print("##");
            for (int j = 0; j < width; j++) {
                if (hasDownWall.get(i).get(j)) {
                    System.out.print("####");
                } else {
                    System.out.print("  ##");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printMaze() {
        System.out.print("   .");
        for (int i = 1; i < width; i++) {
            System.out.print("__.");
        }
        System.out.println();
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {

                if (hasDownWall.get(i).get(j)) {
                    System.out.print("__");
                } else {
                    System.out.print("  ");
                }
                if (hasRightWall.get(i).get(j)) {
                    System.out.print("|");

                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
