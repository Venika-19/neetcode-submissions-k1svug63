class Solution {
public:
    bool isAnagram(string s, string t) {
        int countA[26] = {0};
        int countB[26] = {0};
        for(char c:s){
            countA[c-'a']++;
        }
        for(char c:t){
            countB[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(countA[i]!=countB[i])
            return false;
        }
        return true;
    }
};
