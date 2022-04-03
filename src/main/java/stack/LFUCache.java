package stack;

import java.util.HashMap;

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//https://leetcode.com/problems/lfu-cache/
public class LFUCache {


    HashMap<Integer, DoubleLinkedList> frequency;
    HashMap<Integer, Node> cache;
    int capacity;
    int leastFrequency;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        frequency = new HashMap<>();
        cache = new HashMap<>();
        leastFrequency = 0;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }

        Node node = cache.get(key);
        updateNode(node);
        return node.val;
    }

    public void put(int key, int value) {

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            updateNode(node);
        } else {

            if (cache.size() == capacity) {
                DoubleLinkedList list = frequency.get(leastFrequency);
                list.remove(list.tail.prev);
            }
            leastFrequency = 1;
            Node node = new Node(key, value);

            DoubleLinkedList list;
            if (frequency.containsKey(node.frequency)) {
                list = frequency.get(node.frequency);
            } else {
                list = new DoubleLinkedList(1);
                node.frequency = 1;
                frequency.put(1, list);
            }

            list.insert(node);
        }
    }

    private void updateNode(Node node) {

        DoubleLinkedList list = frequency.get(node.frequency);
        list.remove(node);

        if (node.frequency == leastFrequency && list.size == 0) {
            leastFrequency = node.frequency + 1;
        }

        if (frequency.containsKey(node.frequency + 1)) {
            list = frequency.get(node.frequency + 1);
        } else {
            list = new DoubleLinkedList(node.frequency + 1);
            frequency.put(node.frequency + 1, list);
        }

        node.frequency = node.frequency + 1;
        list.insert(node);
    }

    class Node {
        int key;
        int val;
        int frequency;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.frequency = 1;
            this.prev = this.next = null;
        }
    }

    class DoubleLinkedList {
        int frequency;
        int size;
        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);

        DoubleLinkedList(int frequency) {
            this.frequency = frequency;
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void remove(Node node) {
            cache.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        void insert(Node node) {
            cache.put(node.key, node);

            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
            size++;
        }
    }

    public static void main(String[] args) {

        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.get(1);      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        lfu.get(2);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        lfu.get(1);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        lfu.get(4);      // return 4
        // cache=[4,3], cnt(4)=2, cnt(3)=3

    }
}
