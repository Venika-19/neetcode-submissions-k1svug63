class Solution {
    List<Integer>[] adjList;
    HashSet<Integer> seen;
    HashSet<Integer> visited;
    public boolean detectCycle(int ind){

        if(visited.contains(ind))
            return false;
        visited.add(ind);
        
        boolean ans = true;
        for(int itr: adjList[ind]){
            if(!seen.contains(itr))
                ans = ans && detectCycle(itr);
        }
        seen.add(ind);
        return ans;

    }
    public boolean canFinish(int numCourses, int[][] pre) {
        adjList = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            adjList[i] = new ArrayList<>();
        }
        
        for(int i=0;i<pre.length;i++)
                adjList[pre[i][1]].add(pre[i][0]);
        
        boolean ans = true;
        seen = new HashSet<>();
        List<Boolean> check = new ArrayList<>();
        int ptr = 0;
        for(int i=0;i<numCourses;i++){
            
            if(!seen.contains(i)){

                visited = new HashSet<>();
                check.add(detectCycle(i));
                ans = ans && check.get(ptr);
                ptr++;

                
                 
            }
                

            if(seen.size() == numCourses)
                break;
        }
        return ans;
    }
}
