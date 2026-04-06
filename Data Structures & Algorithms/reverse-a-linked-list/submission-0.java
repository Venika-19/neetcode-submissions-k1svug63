/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode nextt = head;
        ListNode prev = null;
        while(nextt!=null)
        {   
            newHead = nextt;
            nextt = newHead.next;
            newHead.next = prev;
            prev = newHead;
        }
        return newHead;
    }
}
