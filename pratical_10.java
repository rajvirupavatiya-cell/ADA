public class KnapsackDP {

    public static int knapsack(int[] weights, int[] values, int W, int n) {

        int[][] dp = new int[n + 1][W + 1];

        // Build table
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {

                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                }
                else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        values[i - 1] + dp[i - 1][w - weights[i - 1]],
                        dp[i - 1][w]
                    );
                }
                else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {

        int[] weights = {2, 3, 4, 5};
        int[] values  = {3, 4, 5, 6};
        int W = 5;

        int n = weights.length;

        int maxValue = knapsack(weights, values, W, n);

        System.out.println("Maximum value in Knapsack: " + maxValue);
    }
}
