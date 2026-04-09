class Solution {
    public int findMin(int[] nums) {

        

        
        int start = 0, end = nums.length -1;
        while(start <= end){
            int mid = start + (end - start)/2;

            boolean check = nums[mid] <= nums[end];
            if(mid == nums.length -1)
                return nums[mid];
            if(check == true){

                if(mid == 0)
                return nums[0];

                if(nums[mid] < nums[mid-1])
                    return nums[mid];

                end = mid -1;
            }
               
            else{

                
                if(nums[mid] > nums[mid+1])
                    return nums[mid + 1];

                start = mid + 1;
            }
              
            
        }




        return -1;
    }
}
