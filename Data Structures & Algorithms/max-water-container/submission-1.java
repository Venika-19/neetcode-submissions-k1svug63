class Solution {
    public int maxArea(int[] heights) {
        
        int ptr1 = 0, ptr2 = heights.length -1;
        int max = 0;
        while(ptr1 < ptr2){

            int area = Math.min(heights[ptr1], heights[ptr2])*(ptr2-ptr1);
            max = Math.max(area, max);
            if(heights[ptr1] > heights[ptr2])
                ptr2--;
            else
            ptr1++;
        }
        return max;
    }
}
