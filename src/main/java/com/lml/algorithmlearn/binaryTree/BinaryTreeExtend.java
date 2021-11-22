package com.lml.algorithmlearn.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeExtend {

    // Definition for a Node.
    static class Node {
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

    public static Node connect(Node root) {

        //时间复杂度O(n)
        //空间复杂度O(n)
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node pre;
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            pre = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (pre != null) {
                    pre.next = node;
                }
                pre = node;
                if (i == size - 1) {
                    node.next = null;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    public static Node connectBetter(Node root) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        if (root == null) {
            return null;
        }

        Node leftMost = root;
        while (leftMost.left != null) {

            Node head = leftMost;
            while (head != null) {

                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftMost = leftMost.left;
        }
        return root;
    }

    static Node nextStart = null; static Node pre = null;
    public static Node connectDifficult(Node root) {

        if (root == null) {
            return null;
        }
        Node leftMost = root;
        while (leftMost != null) {

            pre = null;
            nextStart = null;
            for (Node p = leftMost; p != null; p = p.next) {

                if (p.left != null) {
                    getNextNode(p.left);
                }
                if (p.right != null) {
                    getNextNode(p.right);
                }
            }
            leftMost = nextStart;
        }
        return root;
    }

    private static void getNextNode(Node node) {

        if (nextStart == null) {
            nextStart = node;
        }
        if (pre != null) {
            pre.next = node;
        }
        pre = node;
    }

    public static void main(String[] args) {

        Node left = new Node(9, null, null, null);
        Node left2 = new Node(15);
        Node right2 = new Node(7);
        Node right = new Node(20, left2, right2, null);
        Node root = new Node(3, left, right, null);
        connectDifficult(root);
    }

}
