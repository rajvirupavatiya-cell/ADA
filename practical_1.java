import java.util.Random;

public class SelectionSortAnalysis {

    // Selection Sort Method
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {

        int size = 10000; // Large dataset (increase if needed)
        int[] data = new int[size];

        Random rand = new Random();

        // Generate random data
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(100000);
        }

        // Measure execution time
        long startTime = System.nanoTime();

        selectionSort(data);

        long endTime = System.nanoTime();

        long duration = endTime - startTime;

        System.out.println("Execution Time: " + duration + " nanoseconds");
        System.out.println("Execution Time: " + (duration / 1_000_000.0) + " milliseconds");
    }
}
