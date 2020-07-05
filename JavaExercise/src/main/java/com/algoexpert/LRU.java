package com.algoexpert;

import java.util.HashMap;

public class LRU {

    static class LRUCache {
        int maxSize;
        int size;
        HashMap<String, CustomDLLNode> map = new HashMap<>();
        CustomDLL stack = new CustomDLL();

        public LRUCache(int maxSize) {
            this.maxSize = maxSize > 1 ? maxSize : 1;
        }

        public void insertKeyValuePair(String key, int value) {
            // Write your code here.

            if(size == maxSize){
                String k = stack.tail.key;
                map.remove(k);
                stack.removeTail();
            }
            else{
                size++;
            }

            CustomDLLNode o = new CustomDLLNode(key,value);
            stack.setAtHead(o);
            map.put(key,o);
        }

        public LRUResult getValueFromKey(String key) {
            // Write your code here.
            if(map.containsKey(key)){

                CustomDLLNode r = map.get(key);
                stack.setAtHead(r);
                return new LRUResult(true,r.value);
            }
            return new LRUResult(false,Integer.MIN_VALUE);
        }

        public String getMostRecentKey() {
            // Write your code here.
            CustomDLLNode mR = stack.head;
            return mR.key;
        }
    }

    static class CustomDLL{

        CustomDLLNode head;
        CustomDLLNode tail;

        public void setAtHead(CustomDLLNode node){
            if(head == node){
                return;
            }
            else if(head == null){
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

        public void removeTail(){

            if(tail == null){
                return;
            }
            if(tail == head){
                head = null;
                tail = null;
                return;
            }
            tail = tail.prev;
            tail.next = null;
        }

    }

    static class CustomDLLNode{

        String key;
        Integer value;
        CustomDLLNode prev;
        CustomDLLNode next;

        public CustomDLLNode(String key,Integer value){
            this.key = key;
            this.value = value;
        }

        public void removeBindings(){
            if(this.prev != null){
                this.prev.next = this.next;
            }
            if(this.next != null){
                this.next.prev = this.prev;
            }
            this.prev = null;
            this.next = null;
        }

    }

    static class LRUResult {
        boolean found;
        int value;

        public LRUResult(boolean found, int value) {
            this.found = found;
            this.value = value;
        }
    }

}
