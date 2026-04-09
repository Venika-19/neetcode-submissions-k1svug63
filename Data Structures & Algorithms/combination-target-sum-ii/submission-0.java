class Solution {

    public void backtrack(List<int[]> nums, int target, List<Integer> arr, List<List<Integer>> ans, int i){

        if(target == 0)
        {
            ans.add(arr);
        }
        if(i == nums.size())
            return;
        
        if(nums.get(i)[0] > target)
            return;
        List<Integer> array = new ArrayList<>();
        array.addAll(arr);
        backtrack(nums, target, array, ans, i+1);

        for(int k = 1;k<=nums.get(i)[1];k++){

            if(target < nums.get(i)[0]*k)
                return;
            array.add(nums.get(i)[0]);
            backtrack(nums, target - k*nums.get(i)[0], array, ans, i+1);
        }
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<int[]> numbers = new ArrayList<>();
        int count = 0, prev = -1;
        for(int i=0;i<candidates.length;i++)
        {
            if( count == 0){
                prev = candidates[i];
                count++;
            }
            else{
                if(prev == candidates[i])
                    count++;
                else{ 
                    numbers.add(new int[]{prev,count});
                    count = 1;
                    prev = candidates[i];
                }
            }
        }

        numbers.add(new int[]{prev,count});
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> array = new ArrayList<>();
        backtrack(numbers, target, array, ans, 0);
        return ans;
    }
}
