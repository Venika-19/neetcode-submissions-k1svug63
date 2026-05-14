class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[3];
        int n = nums.length;
        int ans = 0;
        for(int i=0; i<n;i++){
            int temp = dp[1];
            dp[1] = dp[0] + nums[i];
            dp[0] = temp;
            dp[1] = Math.max(dp[1], dp[0]);
            ans = Math.max(ans, dp[1]);
        }    
        return ans;
    }
}
