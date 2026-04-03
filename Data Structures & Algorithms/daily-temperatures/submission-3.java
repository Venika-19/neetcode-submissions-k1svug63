class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        
        for(int i=0;i<tokens.length;i++){
            if((tokens[i].charAt(0) >= '0' && tokens[i].charAt(0) <= '9')|| (tokens[i].charAt(0) == '-' && tokens[i].length() > 1)){
                s.push(Integer.parseInt(tokens[i]));
            }
        
            else
            {
                char c = tokens[i].charAt(0);
                int b = s.pop(), a = s.pop();
                if(c == '+')
                s.push(a+b);
                else if(c == '*')
                s.push(a*b);
                else if(c == '/')
                s.push(a/b);
                else
                s.push(a-b);
            }
        }

        return s.pop();
    }
}
