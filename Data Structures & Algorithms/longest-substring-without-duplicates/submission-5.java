class Solution {
    public int lengthOfLongestSubstring(String s) {

        int[] count = new int[130];
        int ans =0;
        for(int i=0;i<130;i++){
            count[i] = -1;
        }
        int temp =0;
        int ptr1 = 0;
        int ptr2=0;
        while(ptr2< s.length()){
           int c = s.charAt(ptr2);
            if(count[c]!=-1){

                ans = Math.max(temp, ans);

                
                for(int i=ptr1;i< count[c];i++)
                {
                    count[s.charAt(i)] = -1;
                }   
                ptr1 = count[c]+1;            
                count[c] = ptr2;
                temp = ptr2 - ptr1 + 1;
                ans = Math.max(temp, ans);
            }
            else{

                temp++;
                count[c] = ptr2;
            }

            ptr2++;
        }


        return Math.max(temp,ans);
        
    }
}
