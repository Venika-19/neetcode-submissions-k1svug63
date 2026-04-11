class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 0;
        int max = nums[0];
        if(n > 1){
            ans[1] = 0;
            max = Math.max(max, nums[1]);
        }
            
        if(n > 2){
            ans[2] = nums[0];
            max = Math.max(nums[1], nums[2] + nums[0]);
        }
            
        for(int i=3;i<nums.length;i++){
            ans[i] = Math.max(ans[i-2] + nums[i-2], ans[i-3] + nums[i-3]);
            max = Math.max(ans[i] + nums[i], max);
        }

        return max;
    }
}
