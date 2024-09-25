/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {

        if(root == null) {
            return root;
        }

        Node head = root;
        head.next = null;
        
        while(head != null) {
            Node node = head;
            while(node != null) {
                if(node.left != null) {
                    if(node.right != null) {
                        node.left.next = node.right;
                    } else {
                        node.left.next = getNextRight(node);
                    }
                }
                if(node.right != null) {
                    node.right.next = getNextRight(node);
                }
                node = node.next;
            }

            if(head.left != null) {
                head = head.left;
            } else if(head.right != null) {
                head = head.right;
            } else {
                head = getNextRight(head);
            }
        }

        return root;
    }

    public Node getNextRight(Node node) {
        node = node.next;
        while(node != null) {
            if(node.left != null) {
                return node.left;
            } else if(node.right != null) {
                return node.right;
            }
            node = node.next;
        }

        return null;
    }
}