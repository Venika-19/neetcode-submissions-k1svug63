class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[2];
        int n = nums.length;
        int ans = nums[0];
        for(int i=0; i< n - 1;i++){
            int temp = dp[1];
            dp[1] = dp[0] + nums[i];
            dp[0] = temp;
            dp[1] = Math.max(dp[1], dp[0]);
            ans = Math.max(ans, dp[1]);
        }    
        
        dp = new int[2];
        for(int i=1; i< n;i++){
            int temp = dp[1];
            dp[1] = dp[0] + nums[i];
            dp[0] = temp;
            dp[1] = Math.max(dp[1], dp[0]);
            ans = Math.max(ans, dp[1]);
        } 

        return ans;                                                                                                                                                                                                                                           
    }
}
