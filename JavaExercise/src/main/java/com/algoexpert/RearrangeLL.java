package com.algoexpert;

public class RearrangeLL {

    public static void main(String[] args) {

        RearrangeLL.LinkedList head = new RearrangeLL.LinkedList(3);
        head.next =  new RearrangeLL.LinkedList(0);
        head.next.next =  new RearrangeLL.LinkedList(5);
        head.next.next.next =  new RearrangeLL.LinkedList(2);
        head.next.next.next.next =  new RearrangeLL.LinkedList(1);
        head.next.next.next.next.next =  new RearrangeLL.LinkedList(4);
        System.out.println(rearrangeLinkedList(head,3).value);
    }

    public static LinkedList rearrangeLinkedList(LinkedList head, int k) {
        // Write your code here.

        LinkedList sH = null;
        LinkedList sT = null;
        LinkedList eH = null;
        LinkedList eT = null;
        LinkedList bH = null;
        LinkedList bT = null;

        LinkedList node = head;

        while (node != null) {

            if (node.value == k) {
                LinkedListPair listPair = attach(eH,eT,node);
                eH = listPair.head;
                eT = listPair.tail;

            } else if (node.value > k) {
                LinkedListPair listPair = attach(bH,bT,node);
                bH = listPair.head;
                bT = listPair.tail;
            } else {
                LinkedListPair listPair = attach(sH,sT,node);
                sH = listPair.head;
                sT = listPair.tail;
            }
            node = node.next;
        }


        LinkedListPair listPair = combineLL1(sH,sT,eH,eT);
        LinkedListPair listPair2 = combineLL1(listPair.head,listPair.tail,bH,bT);

        return listPair2.head;
    }

    private static LinkedListPair combineLL1(LinkedList sH, LinkedList sT, LinkedList eH , LinkedList eT) {

        LinkedListPair lp= new LinkedListPair();
        LinkedList head = sH == null ? eH : sH;
        LinkedList tail = eT == null ? sT : eT;

        if(sT !=null){
            sT.next = eH;
        }

        lp.head = head;
        lp.tail = tail;
        return lp;
    }

    private static LinkedListPair attach(LinkedList eH, LinkedList eT, LinkedList node) {

        LinkedListPair listPair = new LinkedListPair();
        LinkedList newHead = eH;
        LinkedList newTail = node;

        if(newHead == null){
            newHead = node;
        }
        else if(eT != null){
            eT.next = node;
        }

        listPair.head = newHead;
        listPair.tail = newTail;

        return listPair;
    }


    static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            next = null;
        }
    }

    static class LinkedListPair {

        public LinkedList head;
        public LinkedList tail;

    }

}
