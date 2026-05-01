public class ShortestCommonSupersequence {

    public static String findSCS(String X, String Y) {

        int m = X.length();
        int n = Y.length();

        int[][] dp = new int[m + 1][n + 1];

        // Step 1: Build LCS table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Step 2: Build SCS string
        StringBuilder scs = new StringBuilder();

        int i = m, j = n;

        while (i > 0 && j > 0) {

            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                scs.append(X.charAt(i - 1));
                i--;
                j--;
            }
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                scs.append(X.charAt(i - 1));
                i--;
            }
            else {
                scs.append(Y.charAt(j - 1));
                j--;
            }
        }

        // Add remaining characters
        while (i > 0) {
            scs.append(X.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            scs.append(Y.charAt(j - 1));
            j--;
        }

        return scs.reverse().toString();
    }

    public static void main(String[] args) {

        String X = "AGGTAB";
        String Y = "GXTXAYB";

        String result = findSCS(X, Y);

        System.out.println("Shortest Common Supersequence: " + result);
        System.out.println("Length: " + result.length());
    }
}
