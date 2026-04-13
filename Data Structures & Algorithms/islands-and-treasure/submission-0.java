class Solution {

    public void bfs(int[][] grid, int i, int j){

        

    }
    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j] == 0)
                q.add(new int[]{i,j});
        }

        if(q.size() == 0)
            return;       
        int l = 1;
        int[] arr;
        int[] p1 = new int[]{0,0,1,-1};
        int[] p2 = new int[]{1, -1, 0, 0};
        while(!q.isEmpty()){

            arr = q.poll();
            for(int k =0;k<4;k++){

                int a = arr[0] + p1[k], b = arr[1] + p2[k];
                if(a < 0 || a >= grid.length || b < 0 || b >= grid[0].length)
                    continue;
                int val = grid[a][b];
                if(val == Integer.MAX_VALUE)
                {   
                    grid[a][b] = grid[arr[0]][arr[1]] + 1;
                    q.add(new int[]{a, b});
                }
                   
            }
        
        }
            
        
    }
}
