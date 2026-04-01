class Solution {
public:
    int longestConsecutive(vector<int>& nums) {

        if(nums.size() == 0)
        return 0;
        
        sort(nums.begin(),nums.end());
        int temp =1, ans =0;
        int prev = nums[0];
        unordered_set<int> a;
        for(int i=0;i<nums.size();i++)
        {
            if(a.find(nums[i])== a.end()){
                a.insert(nums[i]);
                if(prev + 1 == nums[i]){
                    temp++;
                }
                else{
                    if(temp > ans)
                    ans = temp;
                    temp =1;
                }
            }

            prev = nums[i];
        }
        if(temp > ans)
        ans = temp;
        return ans;
    }  
};
