class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char c:tasks)
        count[c - 'A']++;
        int max =0, sum =0;
        for(int i=0;i<26;i++){
            max = Math.max(max, count[i]);
            sum+=count[i];
        }
        int temp = 0;
        for(int i=0;i<26;i++){
            if(count[i] == max)
                temp++;

        }
        int ans = Math.max((max-1)*n + max + temp -1, sum);

        return ans;
        
    }
}
