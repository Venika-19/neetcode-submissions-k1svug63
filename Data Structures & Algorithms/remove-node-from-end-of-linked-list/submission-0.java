class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int count = 0;
        ListNode temp = head;

        // count nodes
        while(temp != null){
            count++;
            temp = temp.next;
        }

        // remove head
        if(n == count){
            return head.next;
        }

        // go to node before target
        int steps = count - n - 1;
        temp = head;

        while(steps > 0){
            temp = temp.next;
            steps--;
        }

        // delete node
        temp.next = temp.next.next;

        return head;
    }
}