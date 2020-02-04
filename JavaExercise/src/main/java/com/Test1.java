package com;

public class Test1 {

    static class LinkedNode{

        int value;
        LinkedNode next;

        LinkedNode(int value){
            this.value = value;
        }

    }

    public static LinkedNode reArrrange(LinkedNode head){

        LinkedNode odd = head;
        LinkedNode even = head.next;

        LinkedNode evenFirst = even;

        while(even!=null && even.next != null){

            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;


        }


        odd.next = evenFirst;
        return head;

    }

    static LinkedNode insertNodeAtTail(LinkedNode head, int data) {

        LinkedNode current = head;
        LinkedNode prev = null;
        while(current != null) {
            prev = current;
            current = current.next;
        }

        prev.next = new LinkedNode(data);
        return head;
    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8};

        LinkedNode head = new LinkedNode(arr[0]);
        LinkedNode current = head;
        for(int i = 1 ; i < arr.length ; i++){

            current.next = new LinkedNode(arr[i]);
            current = current.next;

        }
        current = head;
        while(current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();


        //current =  reArrrange(head);
        current = insertNodeAtTail(head,9);
        while(current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
    }



}
