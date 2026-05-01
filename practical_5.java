import java.util.Random;

public class QuickSortAnalysis {

    // Partition method
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // choosing last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot at correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Quick Sort function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
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

        quickSort(data, 0, data.length - 1);

        long endTime = System.nanoTime();

        long duration = endTime - startTime;

        System.out.println("Execution Time: " + duration + " nanoseconds");
        System.out.println("Execution Time: " + (duration / 1_000_000.0) + " milliseconds");
    }
}
