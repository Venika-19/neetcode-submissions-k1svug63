class Solution {
    public int hammingWeight(int n) {

        int sum =0;
        char[] nums= Integer.toBinaryString(n).toCharArray();
        for(int i=0;i<nums.length;i++){
            if(nums[i] == '1')
                sum+=1;
        }
        return sum;
        
    }
}
