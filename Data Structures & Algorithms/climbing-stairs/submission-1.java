class Solution {
    public int climbStairs(int n) {
        int case1 = 1, case2 =1;
        if(n == 1)
            return 1;
        for(int i=1;i<n;i++){
            int temp =  case2;
            case2 = case2 + case1;
            case1 = temp;
        }    

        return case2;
    }
}
