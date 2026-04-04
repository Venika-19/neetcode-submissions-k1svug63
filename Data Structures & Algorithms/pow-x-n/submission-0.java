class Solution {
    public double myPow(double x, int n) {

        if(n<0)
        {
            n = n*(-1);
            x = 1/x;
        }

        int[] two = new int[11];
        two[0] = 1;
        int v = 0;
        for(int i=1;i<11;i++){
            two[i] = two[i-1]*2;
            if(two[i] > n && v == 0)
                v = i;
        }
        double[] powers = new double[v];

        char[] arr= Integer.toBinaryString(n).toCharArray();

        powers[0] = x;
        for(int i=1;i<v;i++){
            powers[i] = powers[i-1]*powers[i-1];
        }
        double ans = 1;

          for(char c : arr){

            if(c == '1')
                ans = ans*powers[v-1];

            v--;
        }

        return ans;

        
    }
}
