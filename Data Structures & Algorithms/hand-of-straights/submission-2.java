class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {


        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i=0;i<hand.length;i++)
        {    
            min = Math.min(min, hand[i]);
            max = Math.max(max, hand[i]);
        }

        int[] count = new int[max - min + 1];
        for(int i=0;i< hand.length;i++)
            count[hand[i] - min]++;
        for(int i=0;i<count.length ;i++){

            if(count[i] == 0)
                continue;
            int temp = count[i];
            for(int j=i; j < i + groupSize ;j++){

                if(j >= count.length)
                    return false;
                count[j] -= temp;
                if(count[j] < 0)
                    return false;
            }

                
        }

        return true;
        
    }
}
