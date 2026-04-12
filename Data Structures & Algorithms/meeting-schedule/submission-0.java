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
    public boolean canAttendMeetings(List<Interval> intervals) {

        intervals.sort((s1, s2) -> s1.start - s2.start);
        int end = -1;
        for(Interval l: intervals){
            if(end > l.start)
                return false;
            end = l.end;
        }
        return true;

    }
}
