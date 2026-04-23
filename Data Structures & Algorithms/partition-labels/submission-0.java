class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] count = new int[26];
        for(int i=0;i<s.length();i++){
            int c = s.charAt(i) - 'a';
            count[c] = i;        
        }

        int start = 0, end = 0, mid  = 0;
        List<Integer> ans = new ArrayList<>();
        while(end != s.length()){
            
            int c = s.charAt(mid) - 'a';
            if(count[c] > end){
                end = count[c];
                mid++;
            }   
            else{
                if(mid == end){
                    ans.add(end - start + 1);
                    end++;
                    start = end;
                    mid = end;
                }
                else
                    mid++;
            }
        }
        return ans;
    }
}
