class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int ptr1 =0, ptr2 = numbers.length-1;

        while(ptr1 != ptr2){

            while(target - numbers[ptr1] < numbers[ptr2]){
                ptr2--;
            }
            if(target - numbers[ptr1] == numbers[ptr2])
                return new int[]{ptr1+1, ptr2+1};
            ptr1++;
        }
        return new int[]{ptr1+1, ptr2+2};
    }
}
