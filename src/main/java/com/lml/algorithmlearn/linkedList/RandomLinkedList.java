package com.lml.algorithmlearn.linkedList;

/**
 * @Auther: limingliang
 * @Description:
 * @Date: 2021/10/27 09:42
 * Copyright (c) 2017, zaodao All Rights Reserved.
 */
public class RandomLinkedList {

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

    public Node copyRandomList(Node head) {

        return head;
    }
}
