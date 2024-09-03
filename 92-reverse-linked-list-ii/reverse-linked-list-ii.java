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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode temp = head;
         ListNode rightNode = head;

        for(int i = 1; i < left - 1; i++) {
            temp = temp.next;
        }

         for(int i = 1; i < right; i++) {
            rightNode = rightNode.next;
        }

        ListNode leftNode  = temp.next;
        if(left == 1) {
            leftNode = head;
        } else {
            temp.next = null;
        }
       

        ListNode secondTemp = rightNode.next;

        rightNode.next = null;

        ListNode join = reverse(leftNode);
        leftNode.next = secondTemp;
        if(left != 1) {
            temp.next = join;
            return head;
        }

        return join;
        
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode after = null;
        ListNode curr = head;

        while(curr != null) {
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        return prev;

    }
}