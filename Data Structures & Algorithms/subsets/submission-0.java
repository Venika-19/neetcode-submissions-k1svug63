class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<Math.pow(2,nums.length);i++){

            String bits = Integer.toBinaryString(i);
            int j =0;
            List<Integer> inner = new ArrayList<>();
            for(int k=bits.length()-1;k>=0;k--){
                int idx =  bits.charAt(k)- '0';
                
                
                if(idx == 1)
                    inner.add(nums[j]);
                
                j++;
            }
            list.add(inner);

        }
        return list;
    }
}
