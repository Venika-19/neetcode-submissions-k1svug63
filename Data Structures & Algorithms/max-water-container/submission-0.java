class Solution {
    public int maxArea(int[] heights) {

      
        int ptr1 = 0, ptr2 = heights.length -1;

        int max = Integer.MIN_VALUE;

        while(ptr1 <= ptr2){
            max = Math.max(Math.min(heights[ptr1], heights[ptr2])*(ptr2-ptr1), max);
            if(heights[ptr1] < heights[ptr2]){ 
                ptr1++;
            }
            else if(heights[ptr1] > heights[ptr2]){
                ptr2--;
            }
            else{
                ptr1++;
                ptr2--;
            }
    
        }
        
        return max;
    }
}
