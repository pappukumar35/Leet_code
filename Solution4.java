class Solution4 {
    public int paintWalls(int[] cost, int[] time) {
        // code
        int n = cost.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[n][i] = (int) 1e9;
        }
        int opt1;
        int opt2;
        for (int i = n - 1; i >= 0; i--) {
            for (int remain = 1; remain <= n; remain++) {
                opt1 = cost[i] + dp[i + 1][Math.max(0, remain - 1 - time[i])];
                opt2 = dp[i + 1][remain];
                dp[i][remain] = Math.min(opt1, opt2);
            }
        }

        return dp[0][n];

    }
}