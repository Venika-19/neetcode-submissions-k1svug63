class Solution {
    public boolean isPalindrome(String s) {

        String t = "";
        s = s.toLowerCase();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if((c >= 'a' && c <= 'z') || (c>= '0' && c<= '9'))
                t = t + c;
        }

        for(int i=0;i< t.length()/2;i++){
            if(t.charAt(i) != t.charAt(t.length() - i-1))
            return false;
        }
        
        return true;
    }
}
