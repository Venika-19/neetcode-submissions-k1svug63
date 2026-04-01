class Solution {
public:

    string encode(vector<string>& strs) {
        string ans1, ans2;
        for(auto i: strs)
        {
            ans1 += to_string(i.size()) + ',';
            ans2 += i;
        }
        ans1 += '#';
        ans1+= ans2;
        return ans1;
    }

    vector<string> decode(string s) {

        vector<string> ans;
        vector<int> len = {};
        string temp = "";
        int strs =0;
        for(char c: s){
            strs+=1;
            
            if(c == ','){
                len.push_back(stoi(temp));
                temp = "";
            }
            else if(c == '#')
            break;
            else
            temp += c;    
        }
        for(int i:len){
            ans.push_back(s.substr(strs, i));
            strs+=i;
        }
        
        return ans;
    }
};
