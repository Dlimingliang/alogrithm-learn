package com.lml.algorithmlearn.hashtable;

import java.util.HashMap;

public class MyLRU {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));;    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));;    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));;    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));;    // 返回 3
        System.out.println(lRUCache.get(4));;    // 返回 4

    }
    static class LRUCache {
        private HashMap<Integer, Node> map;
        private DoubleList cache;
        private int cap;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            cache = new DoubleList();
            cap = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            makeRecently(key);
            return map.get(key).val;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                removeKey(key);
                addRecently(key, value);
            } else {
                if (cache.size == cap) {
                    removeLeastRecently();
                }
                addRecently(key,value);
            }
        }

        private void makeRecently(int key) {
            Node node = map.get(key);
            cache.remove(node);
            cache.addTail(node);
        }

        private void addRecently(int key, int value) {
            Node node = new Node(key, value);
            map.put(key, node);
            cache.addTail(node);
        }

        private void removeKey(int key) {
            Node node = map.get(key);
            cache.remove(node);
            map.remove(key);
        }

        private void removeLeastRecently() {
            Node node = cache.removeFirst();
            map.remove(node.key);
        }
    }

    static class DoubleList {
        private Node head, tail;
        private int size;

        public DoubleList() {
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addTail(Node x) {
            x.prev = tail.prev;
            x.next = tail;
            tail.prev.next = x;
            tail.prev = x;
            size++;
        }

        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
            size--;
        }

        public Node removeFirst(){
            if (head.next == tail) {
                return null;
            }
            Node res = head.next;
            remove(res);
            return res;
        }
    }

    static class Node {
        public int key, val;
        public Node next, prev;
        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }
}
