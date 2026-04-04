class Solution {
    public boolean hasDuplicate(int[] nums) {

        Map<Integer,Integer> count = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(count.get(nums[i]) != null)
            return true;

            count.put(nums[i], 1);
        }

        return false;
        
    }
}