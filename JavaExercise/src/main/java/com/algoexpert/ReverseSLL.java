package com.algoexpert;

import com.algoexpert.MergeSortedLinkedList;

public class ReverseSLL {

    public static void main(String[] args) {

        LinkedList head = new LinkedList(1);
        head.next = new LinkedList(3);
        head.next.next = new LinkedList(4);
        head.next.next.next = new LinkedList(5);
        head.next.next.next.next = new LinkedList(9);
        head.next.next.next.next = new LinkedList(10);

        LinkedList result = reverseLinkedList(head);

        while(result!=null){
            System.out.print(result.value+" , ");
            result = result.next;
        }
    }

    public static LinkedList reverseLinkedList(LinkedList head) {

        LinkedList p1 = head;
        LinkedList p2 = head.next;
        p1.next = null;

        while(p2!=null){

            LinkedList temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;

        }

        return p1;
        
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

}
