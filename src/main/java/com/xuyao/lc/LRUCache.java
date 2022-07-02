package com.xuyao.lc;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer,Node> map;
    private DoubleLinkeList doubleLinkeList;
    private int capacity;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        doubleLinkeList=new DoubleLinkeList();
        this.capacity=capacity;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node=map.get(key);
        updateNode(key,node.value);
        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            //如果存在
            updateNode(key,value);
        }else{
            //不存在
            //如果超过容量
            if(map.size()==capacity){
                Node lastNode=doubleLinkeList.removeLast();
                map.remove(lastNode.key);
            }
            Node node=new Node(key,value);
            doubleLinkeList.addFirst(node);
            map.put(key,node);
        }

    }

    public void updateNode(int key,int value){
        doubleLinkeList.remove(map.get(key));
        map.remove(key);
        map.put(key,doubleLinkeList.addFirst(new Node(key,value)));
    }


    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(2);
        System.out.printf("null,");
        lruCache.put(1,1);
        System.out.printf("null,");
        lruCache.put(2,2);
        System.out.printf("null,");
        System.out.printf(lruCache.get(1)+",");
        lruCache.put(3,3);
        System.out.printf("null,");
        System.out.printf(lruCache.get(2)+",");
        lruCache.put(4,4);
        System.out.printf("null,");
        System.out.printf(lruCache.get(1)+",");
        System.out.printf(lruCache.get(3)+",");
        System.out.printf(lruCache.get(4)+",");
    }

}

class DoubleLinkeList{
    Node head;
    Node tail;

    public DoubleLinkeList(){
        head=new Node(0,0);
        tail=new Node(0,0);

        head.next=tail;
        tail.prev=head;
    }

    public Node addFirst(Node node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
        return node;
    }

    public Node remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
        return node;
    }

    public Node removeLast(){
        return remove(tail.prev);
    }

}

class Node{
    public int key;
    public int value;
    public Node prev;
    public Node next;

    public Node(int key,int value){
        this.key=key;
        this.value=value;
    }
}