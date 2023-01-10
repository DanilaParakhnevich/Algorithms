package by.parakhnevich.algorithms.findShortestPath;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FindShortestPathSize {
    private static final List<Pair<Integer, Integer>> directions = new ArrayList<>();

    static {
        directions.add(new Pair<>(-1, 0));
        directions.add(new Pair<>(0, -1));
        directions.add(new Pair<>(1, 0));
        directions.add(new Pair<>(0, 1));
    }
    private boolean isSuit(int[][] array, int x, int y) {
        return array[0].length > y && y >= 0 && array.length > x && x >= 0 && array[y][x] != 1;
    }

    private int findShortestPathSize(int[][] array, int x, int y, int size) {
        int[][] arrayForCurrentPath = copyMatrix(array);

        if (arrayForCurrentPath[y][x] == 2) {
            return size;
        }

        arrayForCurrentPath[y][x] = 1;

        List<Integer> resultList = new ArrayList<>();

        for (Pair<Integer, Integer> direction : directions) {
            if (isSuit(arrayForCurrentPath, x + direction.getKey(), y + direction.getValue())) {
                resultList.add(findShortestPathSize(arrayForCurrentPath, x + direction.getKey(), y + direction.getValue(), size + 1));
            }
        }
        if (resultList.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return resultList.stream().min(Comparator.comparingInt(a -> a)).get();
        }
    }

    private int[][] copyMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        return result;
    }

}
