class MedianFinder {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    int size = 0, ptr1 =Integer.MIN_VALUE, ptr2= Integer.MAX_VALUE;
    public MedianFinder() {



        
    }
    
    public void addNum(int num) {



        if(size%2 ==0)
        {
            if(!minHeap.isEmpty())
                ptr1 = minHeap.peek();
            if(!maxHeap.isEmpty())
                ptr2 = maxHeap.peek();
            if(num > ptr1 && num <= ptr2)
                maxHeap.offer(num);
            else if(num < ptr1){
                maxHeap.offer(num);
            }
            else{
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }

        }else{

            if(!maxHeap.isEmpty())
                ptr1 = maxHeap.peek();;
            if(num >= ptr1)
                minHeap.offer(num);
            else if(num < ptr1){
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            }

        }
        size++;
        
    }
    
    public double findMedian() {

        if(size%2 ==0)
        {
            return (((double)minHeap.peek() + (double)maxHeap.peek())/2);
        }else
        return (double)maxHeap.peek();


        
    }
}
