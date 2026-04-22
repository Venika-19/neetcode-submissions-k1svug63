class Solution {

    HashSet<Integer> cycle;
    List<Integer>[] adjList;
    boolean[] visited;
    int cycleStart;
    public boolean dfs(int i, int par){
        if(visited[i] == true){
            cycleStart = i;
            return true;
        }
        visited[i] = true;
        boolean ans = false;
        for(int ind: adjList[i]){
            if(ind != par){
                ans = ans || dfs(ind, i);
            }
        }
        

        if(ans == true)
            cycle.add(i);
        if(cycleStart == i)
            return false;
        return ans;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        adjList = new ArrayList[n];
        visited = new boolean[n];
        for(int i=0;i<n;i++)
            adjList[i] = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adjList[edges[i][0] - 1].add(edges[i][1] - 1);
            adjList[edges[i][1] - 1].add(edges[i][0] - 1);
        }
        cycle = new HashSet<>();
        dfs(0, -1); 

        for(int i=n-1;i>=0;i--){

            if(cycle.contains(edges[i][0] - 1) && cycle.contains(edges[i][1] - 1))
                return edges[i];
        }

        return new int[]{};
    }
}
