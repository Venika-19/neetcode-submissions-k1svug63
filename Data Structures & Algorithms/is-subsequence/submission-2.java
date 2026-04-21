class Solution {
    public boolean isSubsequence(String s, String t) {


        int ptr = 0;
        if(s.length() > 0)
        for(int i=0;i<t.length();i++)
        {
            if(t.charAt(i) == s.charAt(ptr))
                ptr++;
            
            if(ptr == s.length())
                break;
        }

        return ptr == s.length();
    }
}