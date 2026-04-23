class Solution {
    int[][] count;
    public int dfs(int[][] matrix, int i, int j){

        int[][] dirs = new int[][]{{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        int max = 0;
        for(int k=0;k<4;k++){
            int a = i+dirs[k][0], b = j+dirs[k][1];
            if(a < 0 || b <0 || a >= matrix.length || b >= matrix[0].length || matrix[a][b] <= matrix[i][j])
            ;
            else if(count[a][b] > 0)
                max = Math.max(count[a][b], max);
            else
                max = Math.max(dfs(matrix, a, b), max);
        }
        max++;
        count[i][j] = max; 

        return max;
    }
    public int longestIncreasingPath(int[][] matrix) {
        count = new int[matrix.length][matrix[0].length];
        int max = 1;
        for(int i=0;i<matrix.length; i++)
            for(int j=0;j<matrix[0].length; j++){
                if(count[i][j] == 0)
                    max = Math.max(dfs(matrix, i, j), max);
            }
        
        return max;
    }
}
