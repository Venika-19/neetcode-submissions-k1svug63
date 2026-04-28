class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if(target < 0)
            target = target*-1;

        int sum = 0;

        for(int itr: nums)
            sum+= itr;
        
        if((sum + target)%2 !=0)
            return 0;
        
        sum = (sum + target)/2;

        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for(int j=0;j<nums.length;j++){
            for(int i=sum; i>= nums[j];i--){    
                dp[i] = dp[i] + dp[i - nums[j]];
            }
        }
        return dp[sum];
    
    } 
}
