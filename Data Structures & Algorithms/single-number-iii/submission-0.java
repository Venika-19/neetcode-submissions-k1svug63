class Solution {
    public int[] singleNumber(int[] nums) {

        int sum = 0;
        int[] ans = new int[2];
        for(int itr: nums)
            sum = sum^itr;
        int diff = sum & (-sum);
        for(int itr: nums)
            if((diff & itr) == 0)
                ans[0]^=itr;
            else
                ans[1]^= itr;

        return ans;

    }
}