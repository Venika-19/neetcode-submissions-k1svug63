class Solution {
    public int maxProfit(int[] nums) {
        int min = nums[0], max = 0; 

        for(int i=0;i<nums.length;i++){


            if(min > nums[i]){
                min = nums[i];
            }
            else{
                max = Math.max(max, nums[i] - min);
            }

        }  
        return max;
    }
}
