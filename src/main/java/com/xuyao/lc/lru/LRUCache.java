/*
 * Copyright 2021-2022 www.jiahui.com
 */
package com.xuyao.lc.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fei.yang
 * @date 2022/6/7 - 14:25
 */
public class LRUCache {

    private int capacity = 0;
    private Map<Integer, Node> map;
    private DoubleLinkList doubleLinkList;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.doubleLinkList = new DoubleLinkList();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        //将节点置换到前面
        doubleLinkList.updateNode(node);
        return node.getValue();
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            //将节点插入差头部
            Node newNode = doubleLinkList.addFirst(new Node(key, value));
            map.put(key, newNode);
            if (map.size() > capacity) {
                //删除尾部的节点
                Node deleteNode = doubleLinkList.removeLast();
                map.remove(deleteNode.getKey());
            }
        } else {
            //将节点置换到前面
            node.setValue(value);
            doubleLinkList.updateNode(node);
        }

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);

        System.out.print(cache.get(2));
        //        cache.put(1, 1);
        //        cache.put(2, 2);
        //        cache.put(3, 3);
        //        System.out.print(cache.get(1));
        //        System.out.print(cache.get(2));
        //        System.out.print(cache.get(3));
        //        cache.put(4, 4);
        //        System.out.print(cache.get(2));
        //        System.out.print(cache.get(3));
        //        System.out.print(cache.get(3));
        //        cache.put(5, 5);
        //        System.out.print(cache.get(4));
        //        System.out.print(cache.get(3));

    }
}

class DoubleLinkList {

    public Node head;
    public Node tail;

    public DoubleLinkList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.setNext(tail);
        tail.setPrev(head);
    }

    public Node addFirst(Node node) {
        node.setPrev(head);
        node.setNext(head.getNext());
        head.getNext().setPrev(node);
        head.setNext(node);
        return node;
    }

    public Node removeLast() {
        Node lastNode = tail.getPrev();
        tail.setPrev(lastNode.getPrev());
        lastNode.getPrev().setNext(tail);
        return lastNode;
    }

    public Node updateNode(Node node) {
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
        addFirst(node);
        return node;
    }


}


class Node {

    private int key;
    private int value;
    private Node prev;
    private Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(final int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(final Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(final Node next) {
        this.next = next;
    }
}
