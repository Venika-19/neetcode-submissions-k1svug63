class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> count;
        for(int i = 0; i < nums.size(); i++){
            int val = target - nums[i];
            if(count.find(val) != count.end())
                return {count[val], i};
            count[nums[i]] = i;
        }
        return {0,0};
    }
};
