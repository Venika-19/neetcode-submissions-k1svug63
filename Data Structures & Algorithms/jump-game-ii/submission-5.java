class Solution {
    public int jump(int[] nums) {
        int ans = 0, ptr1 = 0;

        while(ptr1 < nums.length - 1){
            
            int index = 0, max = 0;
            ans++;
            if(nums.length - 1 <= ptr1 + nums[ptr1])
                break;
            for(int i = ptr1 + 1; i< Math.min(nums.length, ptr1 + nums[ptr1] + 1); i++){
                if(max <= nums[i] + i){
                    max = nums[i] + i;
                    index = i;
                }
            }
            ptr1 = index;
            
        }

        return ans;
    }
}
