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
    public ListNode partition(ListNode head, int x) {

        if(head == null) {
            return head;
        }
        
        ListNode temp = head;

        ListNode left = null;
        ListNode ltail = null;
        ListNode right = null;
        ListNode rtail = null;    

        while(temp != null) {
            if(temp.val < x) {
                if(left == null) {
                    left = temp;
                    ltail = temp;
                } else {
                    ltail.next = temp;
                    ltail = ltail.next;
                }
            } else {
                if(right == null) {
                    right = temp;
                    rtail = temp;
                } else {
                    rtail.next = temp;
                    rtail = rtail.next;
                }
            }
            temp = temp.next;
        }

        if(left == null) {
            return right;
        }

        ltail.next = right;
        if(right != null) {
            rtail.next = null; 
        }

        return left;
    }
}