class DSU{
    int[] parent;
    int[] size;
    public DSU(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int u){

        if(parent[u] != u)
        {
            parent[u] = find(parent[u]);
        }

        return parent[u];
    }

    public boolean union(int u, int v){
        int up = find(u);
        int vp = find(v);
        if(up == vp)
            return false;
        if(size[up] > size[vp]){
            size[up]+= size[vp];
            parent[vp] = up;
        }else{
            size[vp]+= size[up];
            parent[up] = vp;
        }
        return true;
    }

}

class Solution {
    public int calcDist(int[] a,  int[] b){

        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DSU dsu = new DSU(n);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        for(int i=0; i<n; i++){
            for(int j = i+1; j<n; j++){
                pq.add(new int[]{calcDist(points[i], points[j]), i, j});
            }
        } 

        int sum = 0;
        int ptr = 0;
        while( !pq.isEmpty() && ptr < n-1){

            int[] temp = pq.poll();
            if(dsu.union(temp[1], temp[2])){
                sum+= temp[0];
                ptr++;
            }
        }        
        return sum;
    }
}
