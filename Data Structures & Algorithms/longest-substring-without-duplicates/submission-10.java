class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        boolean[] count = new boolean[137];
        int ptr1 = 0;
        int max = 1;
        for(int i=0; i< s.length();i++){
            int c = s.charAt(i);
            if(count[c])
                max = Math.max(i-ptr1, max);
            while(count[c] == true){
                count[s.charAt(ptr1)] = false;
                ptr1++;
            }
            count[c] = true;
        } 
        max = Math.max(s.length() - ptr1, max);   
        return max;
    }
}
