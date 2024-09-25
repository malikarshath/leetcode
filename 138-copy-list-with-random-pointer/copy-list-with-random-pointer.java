/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }

        // add second element 
        Node temp = head;

        while(temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }

        // point the random pointer

       temp = head;

       while(temp != null) {
        if(temp.random != null) {
            temp.next.random = temp.random.next;
        }
        temp = temp.next.next;
       } 

       //split the list

       Node h1 = head;
       Node h2 = head.next;
       Node newHead = h2;

       while(h1 != null) {
        h1.next = h1.next.next;
        if(h2.next != null) {
            h2.next = h2.next.next;
        }
        h1 = h1.next;
        h2 = h2.next;
       }

       return newHead;


    }
}