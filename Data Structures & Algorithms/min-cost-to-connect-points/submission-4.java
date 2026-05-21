class Solution {
    public int calcDist(int[] a, int[] b){
        return Math.abs(a[1] - b[1]) + Math.abs(a[0] - b[0]);
    }
    public int minCostConnectPoints(int[][] points) {

        int sum = 0;

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>( (a,b) -> a[0] - b[0]);

        int ptr = 0;
        pq.offer(new int[]{0,0});
        int n = points.length;
        while(ptr < n){
            int[] temp = pq.poll();
            if(!visited.contains(temp[1])){
                for(int i=0; i<n;i++){
                    if(i != temp[1] && !visited.contains(i)){
                        pq.offer(new int[]{calcDist(points[temp[1]], points[i]), i});
                    }
                }
                sum += temp[0];
                ptr++;
            }
            visited.add(temp[1]);
            
        }          

        return sum;
    }
}
