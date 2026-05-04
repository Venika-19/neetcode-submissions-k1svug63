class Solution {
    public boolean isMonotonic(int[] nums) {

        int n = nums.length;

        if(n == 1)
            return true;

        int check = 0;

        int ptr = 0;
        while(ptr != n-1 && nums[ptr] == nums[ptr+1] ){
            ptr++;
        }
        if(ptr != n-1)
        if(nums[ptr] > nums[ptr+1]) check = 1;
        else check = 2;

        for(int i= ptr; i< n - 1;i++){

            if(nums[i] > nums[i+1] && check == 2)
                return false;
            if(nums[i] < nums[i+1] && check == 1)
                return false;
        }

        return true;
    }
}