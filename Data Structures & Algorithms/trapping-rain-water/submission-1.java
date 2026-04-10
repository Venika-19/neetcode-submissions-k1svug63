class Solution {
    public int trap(int[] height) {

        int ptr1 = 0, ptr2 = height.length - 1;

        int ans = 0;
        int max1 = 0, ind1 =0, sum = 0, ind2 =0;
        for(int i=0;i<height.length;i++)
        {   
            
            if(height[i] >= max1){
                ans = ans + max1*(i - ind1-1) - sum;
                ind1 = i;
                max1 = height[i];
                sum = 0;
            }
            else
                sum+=height[i];
        }

        max1 = 0; sum = 0;
        for( int i = height.length - 1; i>= ind1; i--){

            if(height[i] >= max1){
                ans = ans + max1*(ind2 - i -1) - sum;
                ind2 = i;
                max1 = height[i];
                sum = 0;
            }
            else
                sum+=height[i];
        }

        return ans;
        
    }
}
