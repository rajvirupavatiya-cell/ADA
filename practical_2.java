import java.util.Random;

public class BubbleSortAnalysis {

    // Bubble Sort Method
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // Optimization: Stop if already sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {

        int size = 10000; // Large dataset
        int[] data = new int[size];

        Random rand = new Random();

        // Generate random data
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(100000);
        }

        // Measure execution time
        long startTime = System.nanoTime();

        bubbleSort(data);

        long endTime = System.nanoTime();

        long duration = endTime - startTime;

        System.out.println("Execution Time: " + duration + " nanoseconds");
        System.out.println("Execution Time: " + (duration / 1_000_000.0) + " milliseconds");
    }
}
