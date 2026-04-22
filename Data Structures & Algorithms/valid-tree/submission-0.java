class Solution {
    HashSet<Integer> visited;
    List<Integer>[] adjList;
    public boolean dfs(int i, int par){

        if(visited.contains(i))
            return false;
        
        visited.add(i);
        boolean ans = true;
        for(int itr: adjList[i]){
            if(itr != par)
                ans = ans && dfs(itr, i);
        }
        return ans;

    }
    public boolean validTree(int n, int[][] edges) {
        visited = new HashSet<>();
        adjList = new ArrayList[n];
        for(int i=0;i<n;i++)
            adjList[i] = new ArrayList<>();

        for(int i=0;i<edges.length;i++){
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }

        return dfs(0,-1) && (visited.size() == n);

    }

}
