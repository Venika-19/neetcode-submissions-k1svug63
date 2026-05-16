class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        

        int start = 0, end = matrix.length - 1;
        int cols = matrix[0].length;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target >= matrix[mid][0] && target <= matrix[mid][cols - 1]){

                int ss = 0, ee = cols - 1;

                while(ss <= ee){
                    int mm = ss + (ee - ss)/2;

                    if(matrix[mid][mm] == target)
                        return true;
                    else if(matrix[mid][mm] > target)
                        ee = mm - 1;
                    else 
                        ss = mm + 1;
                }

                return false;
            }
            else if( target < matrix[mid][0]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return false;
        
    }
}
