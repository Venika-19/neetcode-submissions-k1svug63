class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        map<int,int> count;

        for(int i : nums){
            count[i]++;
            if(count[i] > 1)
            return true;
        }
        return false;

    }
};