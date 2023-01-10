package by.parakhnevich.algorithms.floodFill;

import javafx.util.Pair;

import java.util.*;

public class FloodFill {
    //key is x, value is y
    private static final List<Pair<Integer, Integer>> directions = new ArrayList<>();

    static {
        directions.add(new Pair<>(-1, -1));
        directions.add(new Pair<>(0, -1));
        directions.add(new Pair<>(1, -1));
        directions.add(new Pair<>(-1, 0));
        directions.add(new Pair<>(1, 0));
        directions.add(new Pair<>(-1, 1));
        directions.add(new Pair<>(0, 1));
        directions.add(new Pair<>(1, 1));
    }

    public void fill(char[][] array, int startX, int startY, char replacement) {

        if ((array.length == 0 || array[0].length == 0) || array[startX][startY] == replacement) {
            return;
        }

        Queue<Pair<Integer, Integer>> queueOfSelectedPoints = new ArrayDeque<>();

        queueOfSelectedPoints.add(new Pair<>(startX, startY));

        char target = array[startX][startY];

        if (target == replacement) {
            return;
        }

        while (!queueOfSelectedPoints.isEmpty()) {

            Pair<Integer, Integer> selectedPoint = queueOfSelectedPoints.poll();

            array[selectedPoint.getValue()][selectedPoint.getKey()] = replacement;

            for (Pair<Integer, Integer> direction : directions) {
                if (isSuitForFilling(array, selectedPoint.getKey() + direction.getKey(), selectedPoint.getValue() + direction.getValue(), target)) {
                    queueOfSelectedPoints.add(new Pair<>(selectedPoint.getKey() + direction.getKey(), selectedPoint.getValue() + direction.getValue()));
                }
            }
        }

    }

    private boolean isSuitForFilling(char[][] array, int x, int y, char target) {
        return y >= 0 && y < array.length && x >= 0
                && x < array[0].length && array[y][x] == target;
    }

}
