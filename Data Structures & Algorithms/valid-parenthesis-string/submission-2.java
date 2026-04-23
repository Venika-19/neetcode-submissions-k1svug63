class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer>[] arr = new Stack[2];
        arr[0] = new Stack<>();
        arr[1] = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                arr[0].push(i);
            }
                
            else if(s.charAt(i) == '*')
                arr[1].push(i);
            else{

                if(!arr[0].isEmpty())
                    arr[0].pop();
                else if(!arr[1].isEmpty())
                    arr[1].pop();
                else 
                    return false;   
            }
        }

        while(!arr[0].isEmpty()){
            
            if(arr[1].isEmpty())    
                return false;
            if(arr[0].pop() > arr[1].pop())
                return false;
        }

        return true;
    }
}
