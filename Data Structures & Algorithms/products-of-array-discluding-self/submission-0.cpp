class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        vector<int> arr1 = {1}, arr2 = {1};
        int count1 =1, count2 = 1;
        for(int i: nums){
            count1*=i;
            arr1.push_back(count1);
        }
        for(int i= nums.size()-1;i>=0;i--){
            count2*=nums[i];
            arr2.push_back(count2);
        }
        vector<int> ans={};
        int n = nums.size();
        for(int i=0;i<n;i++){
            ans.push_back(arr1[i]*arr2[n-i-1]);
        }
        return ans;

    }
};
