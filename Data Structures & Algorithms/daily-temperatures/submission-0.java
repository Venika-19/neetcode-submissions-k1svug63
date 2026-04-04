class Solution {
    public int[] dailyTemperatures(int[] temps) {


        Stack<Integer> s = new Stack<>();

        int[] ans = new int[temps.length];

        for(int i=0;i<temps.length;i++){

            while(!s.isEmpty() && temps[s.peek()] < temps[i]){
                int x = s.pop();
                ans[x] = i-x;
            }
            s.push(i);
        }
        return ans;


    }
}
