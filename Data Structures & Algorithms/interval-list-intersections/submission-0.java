class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int ptr1 =0, ptr2 =0;
        List<int[]> ans = new ArrayList<>();    

        while(ptr1 != firstList.length && ptr2 != secondList.length){
            int a = Math.max(firstList[ptr1][0], secondList[ptr2][0]), b = Math.min(firstList[ptr1][1], secondList[ptr2][1]);
            if(a <= b)
                ans.add(new int[]{a, b});
            if(firstList[ptr1][1] < secondList[ptr2][1])
                ptr1++;
            else if(firstList[ptr1][1] > secondList[ptr2][1])
                ptr2++;
            else{
                ptr1++;
                ptr2++;
            }
        }

        int[][] fans = new int[ans.size()][2];

        for(int i=0;i<ans.size();i++)
            fans[i] = ans.get(i);

        return fans;    
    }
}