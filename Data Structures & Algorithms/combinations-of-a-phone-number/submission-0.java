class Solution {
    char[][] dp = new char[10][4];
    public List<String> backtrack(int ind, List<String> ans){

        if(ind == 0 || ind == 1)
            return ans;
        if(ans.size() == 0){
            for(int i=0;i<dp[ind].length;i++){
                if(dp[ind][i]!= 0){
                    String s = "" + dp[ind][i];
                    ans.add(s); 
                }
                
            }
        }else{
            List<String> temp = ans;
            ans = new ArrayList<>();
            for(String s: temp){
                for(int i=0;i<dp[ind].length; i++){
                    if(dp[ind][i]!= 0){
                        ans.add(s + dp[ind][i]);
                    }
                        
                }
            }
            
        }

        return ans;
    }
    public List<String> letterCombinations(String digits) {

        int ptr1 = 0;
        int[] num = {0,0,3,3,3,3,3,4,3,4};
        for(int i=2;i<10;i++){
            int ptr = 0;
            while(ptr!= num[i]){
                dp[i][ptr] = (char)(ptr1 + 'a');
                ptr++;
                ptr1++;
            }
        }
        List<String> ans = new ArrayList<>();
        for(int i=0; i<digits.length();i++){
            ans = backtrack(digits.charAt(i) - '0', ans);
        }
        return ans;
    }
}
