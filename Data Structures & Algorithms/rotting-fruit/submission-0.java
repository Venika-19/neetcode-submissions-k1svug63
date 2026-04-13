class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++)
        for(int j=0;j<n;j++){
            if(grid[i][j] == 2)
                q.add(new int[]{i,j});
            else if(grid[i][j] == 1)
                count++;
        }
        int[] arr;
        int ans = 0;
        while(!q.isEmpty() && count!=0){
            arr = q.poll();
            for(int[] itr: dirs){
                int a = arr[0] + itr[0], b = arr[1] + itr[1];
                if(a >= 0 && a < m && b >=0 && b < n && grid[a][b] == 1){
                    grid[a][b] = grid[arr[0]][arr[1]] + 1;
                    ans = Math.max(ans, grid[a][b] -2);
                    count--;
                    q.add(new int[]{a,b});
                }
            }
        }

        if(count!=0)
            return -1;

        return ans;    
        
    }
}
