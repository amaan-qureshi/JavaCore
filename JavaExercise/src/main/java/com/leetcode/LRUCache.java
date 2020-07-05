package com.leetcode;

import java.util.*;

class LRUCache {

    public static void main(String[] args) {

        LRUCache c = new LRUCache(1);
        c.put(2,1);
        System.out.println(c.get(2));
        c.put(3,2);
        System.out.println(c.get(2));
        System.out.println(c.get(3));
    }

    int capacity;
    int size;
    Map<Integer,DLLNode> map = new HashMap<>();
    DLL dll = new DLL();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {

        if(map.get(key)==null){
            return -1;
        }

        DLLNode recent = map.get(key);
        updateRecent(recent);
        return recent.value;
    }

    public void put(int key, int value) {

        if(map.get(key)==null){
            if(size == capacity){
                int removed = evictLast();
                map.remove(removed);
            }
            else{
                size++;
            }
            DLLNode newNode = new DLLNode(key,value);
            updateRecent(newNode);
            map.put(key,newNode);
        }
        else{
            DLLNode recent = map.get(key);
            recent.value = value;
            updateRecent(recent);
        }

    }

    void updateRecent(DLLNode node){

        if(node==dll.head)
            return;

        if(node == dll.tail){
            dll.removeTail();
            dll.setAtHead(node);
            return;
        }

        if(node.next == null && node.prev == null){
            dll.setAtHead(node);
        }
        else{
            node.removeBindings();
            dll.setAtHead(node);
        }


    }

    int evictLast(){

        return dll.removeTail();

    }

    static class DLL{

        DLLNode head;
        DLLNode tail;
        int length;

        DLL(){
            this.length = 0;
        }

        public void setAtHead(DLLNode node){

            if(head == null){
                head = node;
                tail = node;
            }
            else if(head == tail){
                tail.prev = node;
                head = node;
                head.next = tail;
            }
            else{
                if(tail == node){
                    removeTail();
                }
                node.removeBindings();
                head.prev = node;
                node.next = head;
                head = node;
            }

        }

        public int removeTail(){

            DLLNode oldTail = this.tail;
            DLLNode newTail = oldTail.prev;
            tail = newTail;
            oldTail.removeBindings();
            return oldTail.key;
        }


    }

    static class DLLNode{

        int key;
        int value;
        DLLNode next;
        DLLNode prev;

        DLLNode(int key,int value){
            this.value = value;
            this.key = key;
        }

        public void removeBindings(){

            if(this.prev!=null) this.prev.next = this.next;
            if(this.next!=null) this.next.prev = this.prev;

            this.prev = null;
            this.next = null;
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
