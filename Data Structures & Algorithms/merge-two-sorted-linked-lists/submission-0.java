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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode next = null, head = null;
        while(list1!=null && list2!=null){
            if(next == null)
            {
                if(list1.val >= list2.val)
                {
                    next = list2;
                    list2 = list2.next;
                }
                else
                {
                    next = list1;
                    list1 = list1.next;
                }
                head = next;
            }
            else{


                if(list1.val >= next.val && list1.val <= list2.val){
                    next.next = list1;
                    next = list1;
                    list1 = list1.next;
                }
                else
                {
                    next.next = list2;
                    next = list2;
                    list2 = list2.next;
                }
            }
        
        }
        while(list1!=null){
            if(next != null)
                next.next = list1;
            if(next == null)
                head = list1;
            next = list1;
            list1 = list1.next;
            if(next == null)
                head = next;
        }
        while(list2!=null){
            if(next != null)
                next.next = list2;
            if(next == null)
                head = list2;
            next = list2;
            list2 = list2.next;
            
        }

        return head;
    }
}