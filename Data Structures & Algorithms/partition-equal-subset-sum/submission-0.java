class Solution {
    int total = 0;
    public boolean check(int[] nums, int ind, int sum){

        if(ind == nums.length)
            return false;
        if((sum + nums[ind])*2 == total)
            return true;
        return check(nums, ind+1, sum + nums[ind]) || check(nums, ind+1, sum);
    }
    public boolean canPartition(int[] nums) {
        
        for(int itr: nums)
            total+= itr;
        
        return check(nums, 0, 0);
    }
}
