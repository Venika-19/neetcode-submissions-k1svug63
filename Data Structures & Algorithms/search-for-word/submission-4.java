class Solution {
    int ROWS;
    int COLS;
    public boolean dfs(char[][] board, String word, int ind, int ii, int jj, boolean[][] visited){


        if(visited[ii][jj] || board[ii][jj] != word.charAt(ind))
            return false;
        if(ind == word.length() - 1)
            return true;
        
        visited[ii][jj] = true;
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,-1}, {0, 1}};
        for(int i=0;i<4;i++){

            int c1 = ii + dirs[i][0], c2 = jj + dirs[i][1];

            if(c1 >=0 && c2 >=0 && c1< ROWS && c2 < COLS)
            {
                if(dfs(board, word, ind+1, c1, c2, visited))
                    return true;
            }
        }
        visited[ii][jj] = false;
        return false;
    }
    public boolean exist(char[][] board, String word) {

        ROWS = board.length;
        COLS = board[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        for(int i=0;i<ROWS;i++)
        for(int j=0; j< COLS;j++){
            visited = new boolean[ROWS][COLS];
            if(board[i][j] == word.charAt(0))
                if(dfs(board, word, 0, i, j, visited))
                    return true;
        }
            
                
        return false;
    }
}
