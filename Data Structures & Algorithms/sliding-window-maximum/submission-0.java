class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> discard = new PriorityQueue<>(Collections.reverseOrder());
        

        for(int i=0;i<k;i++)
        pq.offer(nums[i]);

        int[] ans = new int[nums.length-k+1];
        ans[0] = pq.peek();

        for(int i=k;i<nums.length;i++){


            discard.offer(nums[i-k]);
            
            pq.offer(nums[i]);
            while(!discard.isEmpty() && discard.peek() == pq.peek()){
                discard.poll();
                pq.poll();
            }
            ans[i-k+1] = pq.peek();

        }

        return ans;
        
    }
}
