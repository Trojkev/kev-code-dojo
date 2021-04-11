package sorting;

import java.util.Arrays;

public class MergeSortParallel {
    static int[] inputArray = {5, 3, 2, 7, 13, 6, 1, 16};

    public static void main(String[] args) {
        System.out.println("Unsorted : " + Arrays.toString(inputArray));

        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Threads  : " + cores);
        parallelMergeSort(0, inputArray.length - 1, cores);
        System.out.println("Sorted   : " + Arrays.toString(inputArray));
    }

    private static void mergeSort(int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;

            mergeSort(start, mid);
            mergeSort(mid+1, end);

            merge(start, mid, end);
        }
    }

    private static void parallelMergeSort(int start, int end, int numOfThreads) {
        // if we don't have enough threads, let's solve the sort sequentially
        if (numOfThreads <= 1) {
            mergeSort(start, end);
            return;
        }

        int midIdx = (start + end) / 2;

        // otherwise, we create threads
        Thread leftThread = parallelMergeSortHelper(start, midIdx, numOfThreads);
        Thread rightThread = parallelMergeSortHelper(midIdx + 1, end, numOfThreads);

        leftThread.start();
        rightThread.start();

        try {
            leftThread.join();
            rightThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        merge(start, midIdx, end);
    }

    private static Thread parallelMergeSortHelper(int start, int end, int numOfThreads) {
        return new Thread(() -> parallelMergeSort(start, end, numOfThreads / 2));
    }

    private static void merge(int start, int mid, int end) {
        // calculate the lengths of the two sub-arrays to be merged
        int len1 = mid - start + 1;
        int len2 = end - mid;

        // create and initialize the two sub-arrays from the main array
        int[] left = new int[len1];
        int[] right = new int[len2];

        System.arraycopy(inputArray, start, left, 0, len1);
        System.arraycopy(inputArray, mid + 1, right, 0, len2);

        // declare the array indices for iteration
        int i = 0, j = 0;
        int k = start;

        // compare elements from bot arrays and insert the smallest first
        while (i < len1 && j < len2) {
            if (left[i] < right[j]) {
                inputArray[k] = left[i];
                i++;
            } else {
                inputArray[k] = right[j];
                j++;
            }
            k++;
        }

        // insert the rest of the left sub-array
        while (i < len1) {
            inputArray[k] = left[i];
            i++;
            k++;
        }

        // insert the rest of the right sub-array
        while (j < len2) {
            inputArray[k] = right[j];
            j++;
            k++;
        }
    }
}
