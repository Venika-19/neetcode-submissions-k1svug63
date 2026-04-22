class Solution {
    Map<Character, Integer> count;
    public boolean check(){
        
        for(int itr: count.values()){
            if(itr > 0)
                return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {

        int ptr1 =0, ptr2 =0;
        String ans = "";
        count = new HashMap<>();

        for(int i=0;i<t.length();i++)
            count.put(t.charAt(i), count.getOrDefault(t.charAt(i), 0) + 1);

        while(ptr2 != s.length()){


            if(count.containsKey(s.charAt(ptr2))){
                    count.put(s.charAt(ptr2), count.getOrDefault(s.charAt(ptr2), 0) - 1);
            }

            if(check()){

                while(true){
                    if(count.containsKey(s.charAt(ptr1)) &&  count.get(s.charAt(ptr1)) == 0)
                        break;
                    else if(count.containsKey(s.charAt(ptr1)))
                         count.put(s.charAt(ptr1), count.getOrDefault(s.charAt(ptr1), 0) + 1);
                    ptr1++;
                }
                if(ans.equals(""))
                    ans = s.substring(ptr1, ptr2 + 1);
                else{
                    if(ans.length() < ptr2 - ptr1 + 1)
                    ;
                    else
                    ans = s.substring(ptr1, ptr2 + 1);
                }
            }

            ptr2++;
                
        }

        return ans;
        
    }
}
