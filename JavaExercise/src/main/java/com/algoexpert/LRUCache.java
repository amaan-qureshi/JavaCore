package com.algoexpert;

public class LRUCache {



    static class DoublyLinkedList {


        DoublyLinkedNode head = null;
        DoublyLinkedNode tail = null;

        public void setHead(DoublyLinkedNode node){

            if(head == null){
                head = node;
                tail = node;
            }
            else if(head == tail){

                head = node;
                head.next = tail;
                tail.prev = node;
            }
            else{

                if(node == tail){
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
            else if(tail == head){
                head = null;
                tail = null;
            }
            else{
                tail = tail.prev;
                tail.next = null;
            }


        }


    }

    static class DoublyLinkedNode {

        String key;
        int value;

        DoublyLinkedNode next;
        DoublyLinkedNode prev;

        public void removeBindings(){

            if(prev != null){
                prev.next = next;
            }
            if(next != null){
                next.prev = prev;
            }
            prev = null;
            next = null;
        }

    }

}
