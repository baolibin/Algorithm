package libin.base;

import java.util.HashMap;

/**
 * Copyright (c) 2018/8/15. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose :
 */

public class LRUCache {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    Node head = null;
    Node end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 查看某个元素是否命中
     * @param key 命中元素的key值
     * @return 返回命中元素的v值
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            printNodes("get");
            return n.value;
        }
        printNodes("get");
        return -1;
    }

    /**
     * 删除一个节点
     * @param n 要删除的节点
     */
    public void remove(Node n) {
        if (n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }
        if (n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }
    }

    /**
     * 最近被访问的节点插入到头结点
     * @param n  最近被访问的节点
     */
    public void setHead(Node n) {
        n.next = head;
        n.pre = null;
        if (head != null)
            head.pre = n;
        head = n;
        if (end == null)
            end = head;
    }

    /**
     * 插入元素,节点元素为k,v类型
     */
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node created = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
                setHead(created);
            } else {
                setHead(created);
            }
            map.put(key, created);
        }
        printNodes("set");
    }

    /**
     * 打印双向链表
     * @param explain 执行方法标志
     */
    public void printNodes(String explain) {
        System.out.print(explain + ":" + head.toString());
        Node node = head.next;
        while (node != null) {
            System.out.print(node.toString());
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 程序执行主入口
     */
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(5);
        lruCache.set(1, 1);
        lruCache.set(2, 2);
        lruCache.set(3, 3);
        lruCache.set(4, 4);
        lruCache.set(5, 5);
        System.out.println("===========================");
        System.out.println("lruCache.get(1):" + lruCache.get(1));
        lruCache.set(6, 6);
        System.out.println("lruCache.get(2):" + lruCache.get(2));
    }
}

/**
 * 新建数据类型Node节点，Key-Value值，并有指向前驱节点后后继节点的指针，构成双向链表的节点
 */
class Node {
    int key;
    int value;
    Node pre;
    Node next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
    @Override
    public String toString() {
        return this.key + "-" + this.value + " ";
    }
}
