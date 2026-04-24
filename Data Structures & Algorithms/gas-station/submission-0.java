class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum1 =0, sum2 =0;

        for(int i=0;i<gas.length;i++){
            sum1+= gas[i];
            sum2+= cost[i];
        }
        if(sum2 > sum1)
            return -1;
        int store = 0, index = 0;
        for(int i=0;i<gas.length;i++){

            if(store + gas[i] >= cost[i]){
                
                if(store == 0)
                    index = i;
                store = store + gas[i] - cost[i];
            }else
                store = 0;

        }
        return index;
    }
}
