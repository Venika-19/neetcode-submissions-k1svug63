class Solution {
    public int digit(int n){
        List<Integer> ans = new ArrayList<>();

        while(n!=0){
            ans.add(n%10);
            n = n/10;
        }
        int sum = 0;
        for(int itr: ans){
            sum = sum + itr*itr;
        }
        return sum;
    }
    public boolean isHappy(int n) {


        HashSet<Integer> seen = new HashSet<>();

        
        while(!seen.contains(n)){
            seen.add(n);
            n = digit(n); 
        }

        if(n == 1)
            return true;
        return false;
        
    }
}
