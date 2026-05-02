class Solution {
    public int maxEnvelopes(int[][] envelopes) {

        int n = envelopes.length;
        Arrays.sort(envelopes, (a,b) -> Integer.compare(a[0], b[0]));
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=0;i<n;i++){
            for(int j = i+1; j<n;j++){
                if(envelopes[i][0] < envelopes[j][0] && envelopes[i][1] < envelopes[j][1]){
                    dp[j] = Math.max(dp[j], 1 + dp[i]);                 
                }
            }
        }            
        for(int i=0;i<n;i++)
            if(max < dp[i])
                max = dp[i];          
        return max;
    }
}