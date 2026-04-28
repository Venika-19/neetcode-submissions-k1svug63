class Solution {
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i=0;i<nums.length ;i++){

            for(int j= nums.length - 1; j> i;j--){
                
                if(nums[j] > nums[i]){
                    dp[j] = Math.max(dp[i] + 1, dp[j]);
                }

            }
        }    

        int max = 1;
        for(int i=0;i<nums.length;i++)
        max = Math.max(dp[i], max);

        return max;
    }
}
