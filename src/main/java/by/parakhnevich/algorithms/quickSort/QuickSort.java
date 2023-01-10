package by.parakhnevich.algorithms.quickSort;

public class QuickSort {

    public void sort(int[] array, int low) {
        if (low != array.length) {

            int indexToSwap = low;
            int numToSwap = array[low];
            for (int i = low + 1; i < array.length; i++) {
                if (array[i] < numToSwap) {
                    indexToSwap = i;
                    numToSwap = array[i];
                }
            }

            if (numToSwap != array[low]) {
                int a = array[low];
                array[low] = numToSwap;
                array[indexToSwap] = a;
            }

            sort (array, low + 1);
        }
    }

}
