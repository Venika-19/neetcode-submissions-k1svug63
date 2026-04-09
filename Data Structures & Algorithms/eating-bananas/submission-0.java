class Solution {

    public int check(int[] piles, int k)
    {
        
        int sum = 0;
        for(int i=0;i< piles.length;i++){
            sum = sum + (piles[i] + k -1)/k;
        }

        return sum;
    }
    public int minEatingSpeed(int[] piles, int h) {

        int max = Arrays.stream(piles).max().getAsInt();

        int ptr1 = 1, ptr2 = max;
        int start = ptr1, end = ptr2;
        int ans = end;
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            int temp = check(piles, mid);
            
            if( temp <= h){
                ans = mid;
                end = mid - 1;
            }
            else 
                start = mid + 1;
        }

        return ans;
        
    }
}
