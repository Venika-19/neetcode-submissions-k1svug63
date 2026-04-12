/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        intervals.sort(Comparator.comparing((Interval a) -> a.start).thenComparing(a -> a.end));

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int prev = 0;
            for(Interval l: intervals){
                if(!pq.isEmpty())
                    prev = pq.peek();
                if(prev <= l.start){
                    pq.poll();
                    pq.add(l.end);
                }
                else{
                    pq.add(l.end);
                }
            }

            return pq.size();

    }
}
