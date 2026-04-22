class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashSet<Integer>[] freq = new HashSet[nums.length + 1];

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){

            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            freq[i] = new HashSet<>();
        }
        freq[nums.length] = new HashSet<>();
        for(Map.Entry<Integer, Integer> mp: map.entrySet()){
            freq[mp.getValue()].add(mp.getKey());
        }
        int[] ans = new int[k];
        int ptr = 0;
        for(int i = nums.length; i>=0;i--){

            for(int itr : freq[i]){
                ans[ptr] = itr;
                ptr++;

                if(ptr == k)
                break;
            }

            if(ptr == k)
                break;
        }

        return ans;
         
    }
}
