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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head;
        ListNode prev = null;

        for(int i = 1; i < n; i++) {
            second = second.next;
        }

        while(second.next != null) {
            prev = first;
            first = first.next;
            second = second.next;
        }

        if(prev != null) {
            prev.next = prev.next.next;
        } else {
            head = head.next;
        }

        return head;
        
    }
}