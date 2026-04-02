class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
        return "";
        String ans = "";
        int count = 0;
        while(true){
            if(strs[0].length() <= count)
                return ans;
            char temp = strs[0].charAt(count);
            for(int i=0;i<strs.length;i++){
                if(strs[i].length() <= count)
                return ans;
                if(strs[i].charAt(count) != temp){
                    return ans;
                }
            }
            ans = ans + temp;
            count++;
        }

    }
}