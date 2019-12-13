package com.algoexpert;

public class LinkedListLoop {


    public static LinkedList findLoop(LinkedList head) {
        // Write your code here.

        LinkedList p1 = head;
        LinkedList p2 = head;

        while (p1 != null && p2!=null && p2.next != null) {

            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {

                if(p1 == head){
                    return p1;
                }
                else{
                    p1 = head;
                }


                while (true) {
                    p1 = p1.next;
                    p2 = p2.next;

                    if (p1 == p2) {
                        return p1;
                    }
                }
            }

        }

        return null;

    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {

        LinkedList l1 = new LinkedList(1);
        LinkedList l2 = new LinkedList(2);
        LinkedList l3 = new LinkedList(3);
        LinkedList l4 = new LinkedList(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l1;

        LinkedList lx = findLoop(l1);
        System.out.print(lx == null ? null : lx.value);


    }

}
