class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> dp = new ArrayList<>();
        List<Integer> temp;
        for(List<Integer> set: triangle){
            
            temp = new ArrayList<>();
            for(int i = 0;i<set.size();i++){

                if(set.size() == 1)
                    temp.add(set.get(i));
                else if(i == 0)
                    temp.add(dp.get(0) + set.get(i));
                else if(i == set.size() - 1)
                    temp.add(dp.get(set.size() - 2) + set.get(i));
                else
                    temp.add(Math.min(dp.get(i), dp.get(i-1)) + set.get(i));
            }
            dp = temp;
        }

        int min = dp.get(0);
        for(int itr: dp)
            min = Math.min(itr, min);

        return min;
    }
}