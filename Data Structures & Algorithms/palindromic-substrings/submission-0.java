class Solution {
    public int countSubstrings(String s) {
        

        int ptr1 = 0, ptr2 = 0;
        int ans = 0;
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length;i++){

            ptr1 = i;
            ptr2 = i+1;
            while(ptr1 >=0 && ptr2 < arr.length && arr[ptr1] == arr[ptr2]){
                ans+=1;
                ptr1--;
                ptr2++;
            }
            ans+=1;
            ptr1 = i-1;
            ptr2 = i+1;
            while(ptr1 >=0 && ptr2 < arr.length && arr[ptr1] == arr[ptr2]){
                ans+=1;
                ptr1--;
                ptr2++;
            }
        }
        return ans;
    }
}
