class Solution {

    public void backtrack(List<List<Integer>> ans, HashSet<Integer> set, List<Integer> array){

        if(set.size() == 0)
        {
            ans.add(array);
            return;
        }

        for(int i: set)
        {
            HashSet<Integer> set1 = new HashSet<>(set);
            List<Integer> arr = new ArrayList<>(array);
            arr.add(i);
            set1.remove(i);
            backtrack(ans, set1, arr);

        }


    }

    public List<List<Integer>> permute(int[] nums) {
        

        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        set.add(nums[i]);
        List<Integer> arr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, set, arr);
        return ans;
    }
}
