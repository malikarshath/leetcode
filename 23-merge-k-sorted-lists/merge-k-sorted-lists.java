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

        PriorityQueue<NodeVal> min = new PriorityQueue<>();
        for(ListNode ele : lists) {
            if(ele != null) {
                min.add(new NodeVal(ele.val, ele));
            }
        }
        ListNode head = null;
        ListNode tail = null;

        while(!min.isEmpty()) {
            ListNode currNode = min.poll().node;
            if(head == null) {
                head = currNode;
                tail = currNode;
            } else {
                tail.next = currNode;
                tail = tail.next;
            }

            if(currNode.next != null) {
                min.add(new NodeVal(currNode.next.val, currNode.next));
            }
        }

        if(tail != null) {
            tail.next = null;
        }

        return head;
    }

       
}

class NodeVal implements Comparable<NodeVal> {
    int val;
    ListNode node;

    NodeVal(int val, ListNode node) {
        this.val = val;
        this.node = node;
    }

    @Override
    public int compareTo(NodeVal other) {
        return Integer.compare(this.val, other.val);
    }
}