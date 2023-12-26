class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        final int MOD = 1000000007;

        // Check if it's impossible to reach the target with the given number of dice
        // and faces
        if (n * k < target) {
            return 0;
        }

        // Initialize a 2D array to store the number of ways to achieve each target sum
        // using a specific number of dice
        long[][] dp = new long[n + 1][target + 1];

        // Base case: There is one way to get a sum of 0 with 0 dice
        dp[0][0] = 1;

        // Dynamic Programming: Iterate over the number of dice and target sums
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= Math.min(i * k, target); j++) {
                for (int temp = 1; temp <= Math.min(k, j); temp++) {
                    // Update the number of ways to achieve the current target sum
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - temp]) % MOD;
                }
            }
        }

        // Return the result, cast to integer
        return (int) dp[n][target];
    }
}