package com.algoexpert;

public class MergeSortedLinkedList {

    public static void main(String[] args) {

        LinkedList head1 = new LinkedList(2);
        head1.next = new LinkedList(6);
        head1.next.next = new LinkedList(7);
        head1.next.next.next = new LinkedList(8);

        LinkedList head2 = new LinkedList(1);
        head2.next = new LinkedList(3);
        head2.next.next = new LinkedList(4);
        head2.next.next.next = new LinkedList(5);
        head2.next.next.next.next = new LinkedList(9);
        head2.next.next.next.next = new LinkedList(10);

        LinkedList result = mergeLinkedLists(head1,head2);

        while(result!=null){
            System.out.print(result.value+" , ");
            result = result.next;
        }
    }

    public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {
        // Write your code here.

        LinkedList p1 = headOne;
        LinkedList p2 = headTwo;
        LinkedList p1Prev = null;

        while(p1!=null && p2!=null){

            if(p1.value > p2.value){

               if(p1Prev!=null) p1Prev.next = p2;
                p1Prev = p2;
                p2 = p2.next;
                p1Prev.next = p1;

            }
            else{
                p1Prev = p1;
                p1 = p1.next;

            }
        }

        if(p1==null){p1Prev.next = p2;}

        return headOne.value < headTwo.value ? headOne : headTwo;
    }

    public static class LinkedList {
        int value;
        LinkedList next;

        LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
