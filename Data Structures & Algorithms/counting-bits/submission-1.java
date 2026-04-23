class Solution {
    public int[] countBits(int n) {

        int[] ans = new int[n+1];
        int c = 1;
        ans[0] = 0;
        if(n == 0)
            return ans;
        int ptr = 1;
        while(ptr < n+1){
            for(int i=0;i<c;i++){
                ans[ptr] = ans[i] + 1;
                ptr++;
                if(ptr == n+1)
                    break;    
            }
            c = c*2;
        }
        return ans;
    }
}
