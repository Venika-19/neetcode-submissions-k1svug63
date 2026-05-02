class Solution {
    public int numSquares(int n) {

        int k = (int)Math.sqrt(n);
        int[] coins = new int[k];
        int[] dp = new int[n+1];
        for(int i=k;i>0;i--){
            coins[k-i] = i*i;
            dp[coins[k-i]] = 1;
        }    
        for(int coin: coins){
            for(int i=coin + 1; i <= n;i++){
                if(dp[i-coin] > 0)
                    if(dp[i] == 0)
                        dp[i] = dp[i-coin] + 1;    
            }

            if(dp[n] > 0)
                return dp[n];
        }
        return dp[n];
    }
}