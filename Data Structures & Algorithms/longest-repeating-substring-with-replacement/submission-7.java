class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] count = new int[26];
        int ptr = 0;
        int max  =0, ans = 0;

        for(int i =0;i<s.length();i++){
            int c = s.charAt(i) - 'A';
            count[c]++;
            max = Math.max(count[c], max);

            while(i - ptr + 1 - max > k)
            {
                count[s.charAt(ptr) - 'A']--;
                ptr++;
            }

            ans = Math.max(ans, i - ptr + 1);

        }


        return ans;



        
    }
}
