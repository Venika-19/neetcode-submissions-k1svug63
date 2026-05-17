class DSU{
    int[] parents;
    int[] size;
    int components;
    public DSU(int n){
        parents = new int[n];
        size = new int[n];
        components = n;
        for (int i = 0; i < n; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }
    public int find(int node){
        if(parents[node] != node){
            parents[node] = find(parents[node]);
        }

        return parents[node];
    }
    public boolean union(int u, int v){
        int pu = find(u), pv = find(v);
        if (pu == pv) return false;
        
        components--;
         if (size[pu] >= size[pv]) {
            size[pu] += size[pv];
            parents[pv] = pu;
        } else {
            size[pv] += size[pu];
            parents[pu] = pv;
        }
        return true;      
    }

    public int components(){
        return components;
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) { 
        int n = isConnected.length;
        DSU dsu = new DSU(n);

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(isConnected[i][j] == 1)
                    dsu.union(i,j);
            }
        }      

        return dsu.components();
    }
}