import java.util.Random;

public class InsertionSortAnalysis {

    // Insertion Sort Method
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift elements greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        int size = 10000; // Large dataset
        int[] data = new int[size];

        Random rand = new Random();

        // Generate random values
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(100000);
        }

        // Measure execution time
        long startTime = System.nanoTime();

        insertionSort(data);

        long endTime = System.nanoTime();

        long duration = endTime - startTime;

        System.out.println("Execution Time: " + duration + " nanoseconds");
        System.out.println("Execution Time: " + (duration / 1_000_000.0) + " milliseconds");
    }
}
