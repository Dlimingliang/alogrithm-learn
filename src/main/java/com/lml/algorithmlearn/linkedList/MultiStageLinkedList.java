package com.lml.algorithmlearn.linkedList;

/**
 * @Auther: limingliang
 * @Description:
 * @Date: 2021/10/27 08:56
 * Copyright (c) 2017, zaodao All Rights Reserved.
 */
public class MultiStageLinkedList {

    public Node flatten(Node head) {

        //时间复杂度O(n)
        //空间复杂度O(n)
        dfs(head);
        return head;
    }

    public Node dfs(Node node) {

        Node cur = node;
        Node last = null;

        while (cur != null) {

            Node next = cur.next;
            if (cur.child != null) {

                Node childLast = dfs(cur.child);

                next = cur.next;
                //  将 node 与 child 相连
                cur.next = cur.child;
                cur.child.prev = cur;

                //  如果 next 不为空，就将 last 与 next 相连
                if (next != null) {
                    childLast.next = next;
                    next.prev = childLast;
                }

                cur.child = null;
                last = childLast;

            } else {
                last = cur;
            }
            cur = next;
        }
        return last;
    }


    public Node flattenLoop(Node head) {

        //时间复杂度O(n)
        //空间复杂度O(1)
        Node dummy = new Node(0);
        dummy.next = head;
        while (head != null) {

            if (head.child != null) {
                Node tmp = head.next;
                Node child = head.child;
                head.next = child;
                child.prev = head;
                head.child = null;
                Node last = head;
                while (last.next != null) last = last.next;
                last.next = tmp;
                if (tmp != null) tmp.prev = last;
            }
            head = head.next;
        }
        return dummy.next;
    }

}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }
}
