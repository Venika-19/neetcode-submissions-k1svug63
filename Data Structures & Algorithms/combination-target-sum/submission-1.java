class Solution {
    List<List<Integer>> count = new ArrayList<>();
    public void check(int[] nums, int target, List<Integer> array, int ind){

        if(ind == nums.length)
            return;
        List<Integer> arr = new ArrayList<>();
        arr.addAll(array);
        for(int i=0; i<= target/nums[ind];i++){
            
            if(i!=0) 
                arr.add(nums[ind]);
            if(target == nums[ind]*i)
            {
                count.add(arr);
                return;
            }
            else
                check(nums, target - nums[ind]*i, arr, ind+1);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<Integer> arr = new ArrayList<>();
        check(nums, target, arr, 0);

        return count;
        
    }
}
