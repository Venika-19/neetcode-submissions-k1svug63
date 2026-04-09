class Solution {
    List<List<Integer>> count = new ArrayList<>();
    public void check(int[] nums, int target, List<Integer> array, int ind){

        if(ind == nums.length)
            return;
        for(int i=0; i<= target/nums[ind];i++){
            List<Integer> arr = new ArrayList<>();
            arr.addAll(array); 
            arr.add(i);
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
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> itrs : count){
            List<Integer> array = new ArrayList<>();
            for(int j=0;j<itrs.size();j++){
                int c = itrs.get(j);
                for(int k =0; k < c; k++)
                    array.add(nums[j]);
            }
            ans.add(array);
        }
        return ans;
        
    }
}
