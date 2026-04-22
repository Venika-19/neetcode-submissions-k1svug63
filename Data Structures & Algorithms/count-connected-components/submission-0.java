class Solution {
    boolean[] visited;
    List<Integer>[] adjList;
    public void dfs(int i, int par){

        if(visited[i] == true)
            return;
        
        visited[i] = true;

        for(int itr: adjList[i]){
            if(itr != par)
                dfs(itr, i);
        }
    }
    public int countComponents(int n, int[][] edges) {
        
        visited = new boolean[n];
        adjList = new ArrayList[n];
        for(int i=0;i<n;i++)
            adjList[i] = new ArrayList<>();
        
        for(int i=0;i<edges.length;i++){
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }

        int ans = 0;

        for(int i=0;i<n;i++){
            if(visited[i] == false){
                dfs(i, -1);
                ans++;
            }
        }

        return ans;
    }
}
