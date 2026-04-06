class KthLargest {

    PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue();

    int count = 0;

    public KthLargest(int k, int[] nums) {

        

        for(int i=0;i<nums.length;i++){

            maxHeap.add(nums[i]);
        }
        for(int i=0;i<k-1;i++)
        {
            minHeap.add(maxHeap.poll());
        }
        
    }
    
    public int add(int val) {

        if(!minHeap.isEmpty() && val >= minHeap.peek())
        {
            maxHeap.add(minHeap.poll());
            minHeap.add(val);
        }
        else{
            maxHeap.add(val);
        }
        

        return maxHeap.peek();
        
    }

}
