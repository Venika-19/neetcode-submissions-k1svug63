class Solution {


    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]*a[0] + a[1]*a[1]) - (b[0]*b[0] + b[1]*b[1]));

        for(int i=0;i<points.length;i++){
            int[] array = new int[]{points[i][0], points[i][1]};
            pq.offer(array);
        }


        int[] arr = new int[2];
        int[][] ans = new int[k][2]; 
        for(int i=0;i<k;i++){
            arr = pq.poll();
            ans[i] = arr;
        }

        return ans;

    }
}
