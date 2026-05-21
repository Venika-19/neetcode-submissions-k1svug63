class Solution {
    public int calcDist(int[] a, int[] b){
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Set<Integer> visited = new HashSet<>();
        int min = Integer.MAX_VALUE, minInd = 0;
        int ptr = 0, sum = 0;
        dist[0] = 0;
        while(ptr < n){

            visited.add(minInd);
            sum+= dist[minInd];
            int t = minInd;
            for(int i=0; i<n;i++)
            {
                if(!visited.contains(i) && i!= t){
                    int distance = calcDist(points[t], points[i]);
                    if(distance < dist[i]){
                        dist[i] = distance;
                    }
                    if(min > dist[i]){
                        minInd = i;
                        min = dist[i];
                    }
                }
                
            }
            min = Integer.MAX_VALUE;
            ptr++;
        }  
        return sum;  
    }
    
}
