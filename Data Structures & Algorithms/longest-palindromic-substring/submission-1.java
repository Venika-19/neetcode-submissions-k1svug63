class Solution {
    public String longestPalindrome(String s) {
        int ptr1 = 0, ptr2 = 0;
        char[] arr = s.toCharArray();
        String ans = "";
        for(int i=0;i<arr.length;i++){
            String temp = "";
            ptr1 = i; 
            ptr2 = i+1;
            while(ptr1 >= 0 && ptr2 < arr.length && arr[ptr1] == arr[ptr2]){
                temp = arr[ptr1] + temp;
                temp = temp + arr[ptr2];
                ptr1--;
                ptr2++;
            }
            if(ans.length() < temp.length())
                ans = temp;
            temp = "" + arr[i];
            ptr1 = i-1; ptr2 = i+1;
            while(ptr1 >= 0 && ptr2 < arr.length && arr[ptr1] == arr[ptr2]){
                temp = arr[ptr1] + temp;
                temp = temp + arr[ptr2];
                ptr1--;
                ptr2++;
            }
            if(ans.length() < temp.length())
                ans = temp;
        }
        return ans;
    }
}
