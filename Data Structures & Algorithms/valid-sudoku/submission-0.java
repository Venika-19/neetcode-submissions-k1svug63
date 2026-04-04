class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<Integer>[][] sets = new HashSet[3][3];
        for(int i=0;i<3;i++)
        for(int j=0;j<3;j++)
        sets[i][j] = new HashSet<>();

        for(int i=0;i<9;i++)
        {   
            HashSet<Integer> arr = new HashSet<>();
            HashSet<Integer> brr = new HashSet<>();
            for(int j=0;j<9;j++){

                char c = board[i][j];

                if(c == '.')
                ;
                else{
                    int k = c - '0';
                    if(arr.contains(k))
                        return false;
                    arr.add(k);

                    if(sets[i/3][j/3].contains(k))
                        return false;
                    sets[i/3][j/3].add(k);
                }


                c = board[j][i];

                if(c == '.')
                ;
                else{
                    int k = c - '0';
                    if(brr.contains(k))
                        return false;
                    brr.add(k);
                }

            }

        }


        return true;

        
    }
}
