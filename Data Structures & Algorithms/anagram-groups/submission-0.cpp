class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<int>> count;
        int i=0;
        for(string s: strs){
            string t = s;
            sort(t.begin(),t.end());
            if(count.find(t) != count.end()){
                count[t].push_back(i);
            }
            else{
                count[t] = {i};
            }
            i++;
        }
        vector<vector<string>> ans = {};
        for(auto k: count){
            vector<string> sub ={};
            for(int j: k.second){
                sub.push_back(strs[j]);
            }
            ans.push_back(sub);
        }
        return ans;
    }
};
