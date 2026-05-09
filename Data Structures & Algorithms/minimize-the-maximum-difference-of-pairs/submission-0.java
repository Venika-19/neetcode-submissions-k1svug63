class Solution {
    public int minimizeMax(int[] nums, int p) {
        // If no pairs are required, answer is 0.
        if (p == 0) {
            return 0;
        }

        int n = nums.length;
        if (n < 2) {
            return 0;
        }

        Arrays.sort(nums);

        // dp[i][j] = minimum possible maximum difference
        // using adjacent pairs from indices 0..i,
        // where j means exactly (j + 1) pairs are formed.
        int[][] dp = new int[n][p];

        // Initialize all values to infinity.
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // Base case: forming exactly 1 pair (j = 0).
        // At position i, the pair is (i, i + 1).
        for (int i = 0; i < n - 1; i++) {
            int diff = nums[i + 1] - nums[i];

            if (i == 0) {
                dp[i][0] = diff;
            } else {
                // Either take the current pair alone,
                // or keep the best single pair seen so far.
                dp[i][0] = Math.min(dp[i - 1][0], diff);
            }
        }

        // Fill DP for 2 to p pairs.
        for (int i = 1; i < n - 1; i++) {
            int diff = nums[i + 1] - nums[i];

            for (int j = 1; j < p; j++) {
                // Option 1: Skip the current pair.
                dp[i][j] = dp[i - 1][j];

                // Option 2: Take the current pair (i, i + 1).
                // Previous pairs must end at or before i - 2.
                if (i >= 2 && dp[i - 2][j - 1] != Integer.MAX_VALUE) {
                    int candidate = Math.max(dp[i - 2][j - 1], diff);
                    dp[i][j] = Math.min(dp[i][j], candidate);
                }
            }
        }

        // Last valid row is n - 2 because pairs use (i, i + 1).
        int ans = dp[n - 2][p - 1];

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}