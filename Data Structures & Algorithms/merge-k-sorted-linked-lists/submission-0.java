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
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode head = null, minNode = null;

        while(true){
            
            int min = Integer.MAX_VALUE;
            int minInd = -1;
            for(int i=0; i<lists.length;i++){
            
                if(lists[i]!=null){
                    if(min > lists[i].val){
                        minInd = i;
                        min = lists[i].val;
                    }
                }
                
            }
            if(minInd == -1)
                break;

            if(head == null){
                minNode = lists[minInd];
                head = minNode;
            }else{
                minNode.next = lists[minInd];
                minNode = minNode.next;
            }
           
            lists[minInd] = lists[minInd].next;
            
        }
        return head;
    }
}
