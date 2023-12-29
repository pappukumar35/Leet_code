import java.util.Arrays;
import java.util.List;
import java.util.Vector;

class Solution {
    public int minDifficulty(List<Integer> jobDifficulty, int d) {
        int n = jobDifficulty.size();
        if (n < d) {
            return -1;
        } else if (n == d) {
            int totalDifficulty = 0;
            for (int difficulty : jobDifficulty) {
                totalDifficulty += difficulty;
            }
            return totalDifficulty;
        }

        // dp[j]: the minimum difficulty of the first (j+1) jobs, exactly scheduled in
        // (i+1) days
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = jobDifficulty.get(0);

        // Initializing the dp array to store the maximum difficulty encountered so far
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], jobDifficulty.get(i));
        }

        int[] dpPrev = new int[n];

        // Dynamic Programming to find the minimum difficulty
        for (int i = 1; i < d; i++) {
            int[] temp = dpPrev;
            dpPrev = dp;
            dp = temp;
            for (int j = i; j < n; j++) {
                int lastDayDifficulty = jobDifficulty.get(j);
                int tmpMin = lastDayDifficulty + dpPrev[j - 1];

                // Iterate to find the minimum difficulty for the current day
                for (int t = j - 1; t >= i - 1; t--) {
                    lastDayDifficulty = Math.max(lastDayDifficulty, jobDifficulty.get(t));
                    tmpMin = Math.min(tmpMin, lastDayDifficulty + dpPrev[t - 1]);
                }

                dp[j] = tmpMin;
            }
        }

        return dp[n - 1];
    }
}