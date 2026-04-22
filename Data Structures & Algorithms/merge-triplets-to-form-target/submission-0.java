class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        HashSet<Integer> ans = new HashSet<>();

        for(int i=0;i<triplets.length;i++){

            boolean check = true;
            List<Integer> values = new ArrayList<>();
            for(int j=0;j<3;j++){

                if(target[j] == triplets[i][j])
                    values.add(j);
                else 
                    check = check && (target[j] > triplets[i][j]);
            }
            if(check)
            for(int itr: values)
            {
                ans.add(itr);
            }

            if(ans.size() == 3)
                return true;
        }

        return false;
    }
}
