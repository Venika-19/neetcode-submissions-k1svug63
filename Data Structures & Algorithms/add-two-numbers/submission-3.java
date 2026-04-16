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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = l1, temp;
        int carry = 0;
        ListNode zero = new ListNode(0);
        while(true){
            if(carry == 1){
                l1.val++;
                carry = 0;
            }
            if(l1.val + l2.val > 9)
            {
                carry = 1;
                l1.val = l1.val + l2.val - 10;
            }else
                l1.val = l1.val + l2.val;
            if(l1.next == null && l2.next == null){
                if(carry ==1)
                    l1.next = new ListNode(1);
                break;
            }
            else if(l1.next == null && l2.next !=null){
                l1.next = l2.next;
                l1 = l1.next;
                l2 = zero;

            }
            else if(l1.next != null && l2.next == null){
                l2 = zero;
                l1 = l1.next;
            }
            else{
            l1 = l1.next;
            l2 = l2.next;
            }
        }
        return head;
    }
}
