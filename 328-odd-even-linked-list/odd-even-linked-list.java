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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return null;
        }

        if(head.next == null) {
            return head;
        }

        if(head.next.next == null) {
            return head;
        }

        ListNode h1 = head;
        ListNode h2 = head.next;
        ListNode s2 = head.next;
        ListNode t1 = head;

        while(h1 != null && h2 != null) {
            if(h1.next != null) {
                h1.next = h1.next.next;
            }
            if(h2.next != null) {
                h2.next = h2.next.next;
            }

            t1 = h1;
            h1 = h1.next;
            h2 = h2.next;
        }

        if(h1 == null) {
            t1.next = s2;
        } else {
            h1.next = s2;
        }


        return head;
        
    }
}