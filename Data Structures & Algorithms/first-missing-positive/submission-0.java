class Solution {
    public int firstMissingPositive(int[] nums) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int curr = 1;

        for(int i=0;i<nums.length;i++){
            if(nums[i] == curr){
                curr++;
                while(!pq.isEmpty() && curr == pq.peek()){
                    curr++;
                    pq.poll();
                }
            }else{
                if(nums[i] > curr)
                    pq.add(nums[i]);
            }
            
        }
        return curr;
        
    }
}