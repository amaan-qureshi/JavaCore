package com.algoexpert;

public class ShiftLL {

    public static void main(String[] args) {

        LinkedList head = new LinkedList(0);
        head.next =  new LinkedList(1);
        head.next.next =  new LinkedList(2);
        head.next.next.next =  new LinkedList(3);
        head.next.next.next.next =  new LinkedList(4);
        head.next.next.next.next.next =  new LinkedList(5);
        System.out.println(shiftLinkedList(head,2).value);
    }

    public static LinkedList shiftLinkedList(LinkedList head, int k) {


        int size = 1;
        LinkedList tail = head;
        while(tail.next !=null ){
            tail = tail.next;
            size++;
        }

        int offset = Math.abs(k)%size;
        int tailPositionIdx = k > 0 ? size - offset : offset;

        LinkedList newtail = head;
        for(int i = 1 ; i < tailPositionIdx ; i++){
            newtail = newtail.next;
        }

        tail.next = head;
        head = newtail.next;
        newtail.next = null;

        return head;
    }

    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }

}
