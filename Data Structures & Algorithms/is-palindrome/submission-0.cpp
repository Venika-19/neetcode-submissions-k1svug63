#include<bits/stdc++.h>
class Solution {
public:
    string check(string s)
    {
        string ans = "";
        transform(s.begin(), s.end(), s.begin(), ::tolower);
        for(int i=0;i<s.size();i++){

            if((s[i] >= '0' && s[i]<='9') || (s[i] >='a' && s[i] <= 'z'))
            ans += s[i];
        }
        return ans;
        
    }
    bool isPalindrome(string s) {
        string z = check(s);
        int ptr = z.size() -1;
        char a,b;
        int i =0;
        while(i!= z.size()){
            
            a = z[i];
            b = z[ptr];
            
            if( a!=b)
            return false;
            i++;
            ptr--;
            
        }
       return true;
    }
};
