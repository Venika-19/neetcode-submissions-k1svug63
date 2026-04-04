class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> s = new Stack<>();
        int max = 0;

        int[] arr1 = new int[heights.length];
        int[] arr2 = new int[heights.length];

        for(int i=0;i<heights.length;i++){
            while(!s.isEmpty() && heights[s.peek()] > heights[i]){

                int x = s.pop();
                arr1[x] = i-1;
            }
            s.push(i);
        }

        while(!s.isEmpty())
        arr1[s.pop()] = heights.length -1;

        for(int i=heights.length -1;i>=0;i--){
            while(!s.isEmpty() && heights[s.peek()] > heights[i]){

                int x = s.pop();
                arr2[x] = i+1;
            }
            s.push(i);
        }

        while(!s.isEmpty())
        arr2[s.pop()] = 0;
        

        for(int i=0;i<heights.length;i++){

            max = Math.max((arr1[i] - arr2[i]+1)*heights[i], max);
        }
        
        return max;
        
    }
}
