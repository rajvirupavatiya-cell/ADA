import java.util.Arrays;

public class CoinChangeDP {

    public static int minCoins(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // Initialize dp array
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // Build DP table
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If not possible
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;

        int result = minCoins(coins, amount);

        if (result != -1)
            System.out.println("Minimum coins required: " + result);
        else
            System.out.println("Change cannot be made");
    }
}
