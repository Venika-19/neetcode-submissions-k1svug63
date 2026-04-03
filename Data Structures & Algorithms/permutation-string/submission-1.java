class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
        return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for(int i=0;i<s1.length();i++){
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for(int i=0;i<26;i++){
            if(count1[i] == count2[i])
            matches++;
        }

        for(int i=s1.length();i<s2.length();i++){

            if(matches == 26)
                return true;

            int x = s2.charAt(i-s1.length()) - 'a';
            int y = s2.charAt(i) - 'a';

            if(count1[x] == count2[x])
            matches--;
            if(count1[y] == count2[y])
            matches--;
            count2[x]--;
            count2[y]++;
            if(count1[x] == count2[x])
            matches++;
            if(count1[y] == count2[y])
            matches++;
        }

        

        return matches == 26;

    }
}
