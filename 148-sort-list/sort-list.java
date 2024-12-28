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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);

        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;
        ListNode sortedLeft = sortList(left);
        ListNode sortedRight = sortList(right);

        return merge(sortedLeft, sortedRight);

    }

    public ListNode merge(ListNode left, ListNode right) {
        if(left == null && right == null) {
            return null;
        }
        if(left == null) {
            return right;
        }
        if(right == null) {
            return left;
        }
        ListNode newHead = null;
        ListNode tail = null;
        if(left.val <= right.val) {
            newHead = left;
            tail = left;
            left = left.next;
        } else {
            newHead = right;
            tail = right;
            right = right.next;
        }

        while(left != null && right != null) {
            if(left.val <= right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        if(left != null) {
            tail.next = left;
        }else if(right != null) {
            tail.next = right;
        }

        return newHead;
    }

    public ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}