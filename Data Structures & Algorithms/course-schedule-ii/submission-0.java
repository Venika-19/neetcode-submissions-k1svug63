class Solution {
    int[] ans;
    List<Integer>[] adjList;
    HashSet<Integer>[] inDegree;
    public int[] findOrder(int numCourses, int[][] pre) {
        ans = new int[numCourses];
        adjList = new ArrayList[numCourses];
        inDegree = new HashSet[numCourses];
        for(int i=0;i<numCourses;i++){
            adjList[i] = new ArrayList<>();
            inDegree[i] = new HashSet<>();
        }

        for(int i=0;i<pre.length;i++){
            adjList[pre[i][1]].add(pre[i][0]);
            inDegree[pre[i][0]].add(pre[i][1]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i].isEmpty())
                q.add(i);
        }
        
        
        int ptr = 0;
        while(!q.isEmpty()){

            int a = q.poll();
            ans[ptr] = a;
            ptr++;
            for(int itr: adjList[a]){
                inDegree[itr].remove(a);
                if(inDegree[itr].isEmpty())
                    q.add(itr);
            }

        }

        if(ptr == numCourses)
            return ans;

        return new int[]{};     
    }
}
