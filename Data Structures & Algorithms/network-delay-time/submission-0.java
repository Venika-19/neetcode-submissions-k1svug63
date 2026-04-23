class Solution {
    List<int[]>[] adjList;
    public int networkDelayTime(int[][] times, int n, int k) {

        adjList = new ArrayList[n];

        for(int i=0;i<n;i++)
            adjList[i] = new ArrayList<>();
        
        for(int i=0;i<times.length;i++){
            adjList[times[i][0] - 1].add(new int[]{times[i][1] - 1, times[i][2]});
        }

        int[] visited = new int[n];
        for(int i=0;i<n;i++)
            visited[i] = Integer.MAX_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0, k-1});
        visited[k-1] = 0;
        while(!pq.isEmpty()){

            int[] arr = pq.poll();

            for(int[] itr: adjList[arr[1]]){
                if(visited[itr[0]] > arr[0] + itr[1]){
                    visited[itr[0]] = arr[0] + itr[1];
                    pq.add(new int[]{visited[itr[0]], itr[0]});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
            max = Math.max(visited[i], max);


        return (max != Integer.MAX_VALUE) ? max : -1;

        
    }
}
