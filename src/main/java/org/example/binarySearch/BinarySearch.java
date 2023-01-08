package org.example.binarySearch;

import java.util.List;

public class BinarySearch {

    private int[] array;
    private int left;
    private int mid;
    private int right;

    public BinarySearch(int[] array) {
        this.array = array;
        this.left = 0;
        this.right = array.length - 1;
    }

    public int search(int value) {
        while (left <= right) {
            mid = (left + right) / 2;

            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                left = left + 1;
            } else {
                right = right - 1;
            }
        }
        return -1;
    }
}
