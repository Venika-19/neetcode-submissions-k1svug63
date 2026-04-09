class Solution {

    public void subset(char[] bin, List<int[]> list, List<List<Integer>> ans, List<Integer> array, int ind){

        if(ind == list.size()){
            ans.add(array);
            return;
        }
        if(bin[ind] == '0'){ 
            List<Integer> arr = new ArrayList<>(array);
            subset(bin, list, ans, array, ind+1); 
        }
            
        else{
            List<Integer> arr = new ArrayList<>(array);
            for(int i=1;i<=list.get(ind)[1];i++){
                arr.add(list.get(ind)[0]);
                List<Integer> arr1 = new ArrayList<>(arr);
                subset(bin, list, ans, arr1, ind+1);
            }
        }

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        List<int[]> list = new ArrayList<>();
        int count =1, prev = nums[0];
        for(int i=1;i<nums.length;i++){
            if(prev == nums[i])
                count++;
            else{
                
                list.add(new int[]{prev, count});
                count = 1;
                prev = nums[i];
            }
            
        }
        list.add(new int[]{prev, count});
       
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> array = new ArrayList<>();
        for(int i=0;i<Math.pow(2,list.size());i++){

            char[] length = new StringBuilder(String.format("%" + list.size() + "s", Integer.toBinaryString(i)).replace(' ', '0')).reverse().toString().toCharArray();;
            subset(length, list, ans, array, 0);
        }
        return ans;
    }
}
