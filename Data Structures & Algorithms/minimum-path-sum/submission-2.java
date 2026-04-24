class Solution {
    public int minPathSum(int[][] grid) {
        int cost[][] = new int[grid.length][grid[0].length];
        cost[0][0] = grid[0][0];

        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++){
                
                int down = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
                if(i!= 0)
                    down = cost[i-1][j];
                if( j!= 0)
                    right = cost[i][j-1];
                if(i+j != 0)
                    cost[i][j] = Math.min(down, right) + grid[i][j];
                else 
                    cost[i][j] = grid[i][j];
            }

        return cost[grid.length - 1][grid[0].length - 1];

    }
}