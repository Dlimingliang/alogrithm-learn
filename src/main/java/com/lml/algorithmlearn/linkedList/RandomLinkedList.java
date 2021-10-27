package com.lml.algorithmlearn.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: limingliang
 * @Description:
 * @Date: 2021/10/27 09:42
 * Copyright (c) 2017, zaodao All Rights Reserved.
 */
public class RandomLinkedList {

    class Node {
        int val;
        int randomIndex;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {

        // 时间复杂度O(n)
        // 空间复杂度O(n)
        if (head == null) {
            return null;
        }

        if (!cachedNode.containsKey(head)) {

            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }

    public Node copyRandomListBetter(Node head) {

        //时间复杂度O(n)
        //空间复杂度O(n)
        if (head == null) {
            return null;
        }

        //复制新节点到后面
        for(Node node = head; node != null ; node = node.next.next) {

            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }

        //复制随机节点
        for(Node node = head; node != null ; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }

        //去除老节点
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            Node nodeNew = node.next;
            node.next = node.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }
}
