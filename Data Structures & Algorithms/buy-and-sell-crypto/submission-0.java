class Solution {
    public int maxProfit(int[] prices) {
        int max = -1, min = prices[0], ans = 0, diff =0;
        for(int i=0;i<prices.length;i++){
            if(prices[i] < min){
                min = prices[i];  
                max = -1;              
            }
            else if(prices[i] > max){
                max = prices[i];
                if(max != -1){
                    diff = max - min;
                    if(diff > ans)
                    ans = diff;
                }
            }

        }
        return ans;
    }
}
