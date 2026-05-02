class Solution {
    public int numRescueBoats(int[] people, int limit) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        for(int i=0;i< people.length;i++){
            max.add(people[i]);
            min.add(people[i]);
        }    
        int count = 0;
        int ans = 0;
        while(count < people.length){

            int a = max.poll();
            count++;
            if(count == people.length){
                ans++;
                break;
            }
            if(a == limit){
                ans++;
                continue;
            }
            
            int b = min.poll();
            count++;

            if(b == limit){
                ans++;
                continue;
            }

            if(a + b <= limit){
                ans++;
            }else{
                ans++;
                min.add(b);
                count--;
            }
        }
        return ans;
    }
}