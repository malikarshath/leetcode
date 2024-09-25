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
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null) {
            return head;
        }
        
        ListNode temp  = head;

        ListNode after = null;
        ListNode prevTail = null;

        ListNode newHead = null;
        while(temp != null) {
            ListNode curr = temp;
            int reversed = 0;
            ListNode prev = null;
            while(curr != null && reversed < k) {
                after = curr.next;
                curr.next = prev;
                prev = curr;
                curr =  after;
                reversed++;
            }
            if(reversed < k) {
                curr = prev;
                prev = null;
                after = null;
                while(curr != null) {
                    after = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr =  after;
                }
            }
            if(prevTail != null) {
                prevTail.next = prev;
            }
            if(newHead == null) {
                newHead = prev;
            }
            prevTail = temp;
            temp = curr;
        }

        return newHead;
    }

    // public ListNode reverse(ListNode head, int k) {
    //     ListNode prev = null;
    //     ListNode curr = head;
    //     ListNode after = null;
    //     int reversed = 0;

    //     while(curr != null && reversed < k) {
    //         after = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr =  after;
    //         reversed++;
    //     }

    //     return prev;
    // }
}