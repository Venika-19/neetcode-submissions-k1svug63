class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
       int ptr1 = 0, ptr2 = nums.size()-1;
       while(ptr1!=nums.size()){
            int val = target - nums[ptr1];

            while(nums[ptr2] >= val)
            {
                if(nums[ptr2] == val)
                return{ptr1+1, ptr2+1};

                ptr2--;
            }

            ptr1++;

       }
       return {};
    }
};
