package com.leetcode;

public class ReverseNodesInGroup {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        ReverseNodesInGroup o = new ReverseNodesInGroup();
        o.print(head);
        ListNode result = o.reverseKGroup(head,2);
        System.out.println();
        o.print(result);
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        int c = 0;
        ListNode curr = head;

        while(c<k && curr!=null){
            curr = curr.next;
            c++;
        }

        if(c==k){
            ListNode reversedHead = reverse(head, k);
            head.next = reverseKGroup(curr,k);
            return reversedHead;
        }

        return head;

    }


    public ListNode reverse(ListNode head ,int k) {

        ListNode prev = null;
        ListNode curr = head;

        while (k > 0) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            k--;
        }

        return prev;
    }

    public void print(ListNode head) {

        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("null");
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
