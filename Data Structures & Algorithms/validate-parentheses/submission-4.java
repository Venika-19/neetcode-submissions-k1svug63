class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c == '{')
            s.push('}');
            else if(c == '[' )
            s.push(']');
            else if(c == '(')
            s.push(')');
            else{
                if(s.size() == 0)
                return false;
                char k = s.pop();
                if(k!=c)
                return false;
            }

        }
        
        return s.size() == 0;
    }
}
