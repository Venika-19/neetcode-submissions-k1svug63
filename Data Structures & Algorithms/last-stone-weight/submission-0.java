class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++){
            heap.add(stones[i]);
        }

        while(heap.size() > 1){
            int a = heap.poll();
            int b = heap.poll();
            heap.add(Math.abs(a-b));
        }
        if(heap.isEmpty())
        return 0;
        return heap.poll();
    }
}
