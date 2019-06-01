package leetcode.recursion;

import java.util.LinkedList;

public class ReverseLinkedList_8 {

    /**
     * Reverse a singly linked list.
     *
     * Example:
     *
     * Input: 1->2->3->4->5->NULL
     * Output: 5->4->3->2->1->NULL
     * Follow up:
     *
     * A linked list can be reversed either iteratively or recursively. Could you implement both?
     */

    public static void main(String[] args) {

        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(4);
        ListNode node_5 = new ListNode(5);

        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;

//        printListNode(reverseListMyAnswerIterative(node_1));

//        printListNode(reverseListMyAnswerIterative2(node_1));

//        printListNode(reverseListMyAnswerIterative3(node_1));

//        printListNode(reverseListMySolutionRecursive(node_1));

        printListNode(reverseListMySolutionRecursive(node_1));

    }

    public static void printListNode(ListNode head) {

        while (head != null) {
            System.out.print(head.val + "->");

            head = head.next;
        }

        System.out.print("NULL");
        System.out.println();

    }

    public static void printStack(LinkedList<ListNode> stack) {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().val + ",");
        }
        System.out.println();

    }



    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x;}
    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    /**
     * Iterative
     * Runtime : 1ms
     * Memory : 36.4Mb
     * Time complexity : O(n)
     */
    public static ListNode reverseListMyAnswerIterative(ListNode head) {

        if (head == null) {
            return null;
        }

        LinkedList<ListNode> stack = new LinkedList<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode newHead = stack.pop();
        ListNode current = newHead;
        while (!stack.isEmpty()) {

            ListNode node = stack.pop();

            current.next = node;
            current = node;
        }

        current.next = null;

        return newHead;
    }

    public static ListNode reverseListMyAnswerIterative2(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        //1->2->3->4->5
        while (current != null) {
            ListNode nextTmp = current.next;
            current.next = prev;

            prev = current;
            current = nextTmp;

        }
        return prev;

    }


    /**
     * Runtime : 0ms
     * Memory : 36.4Mb
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public static ListNode reverseListMyAnswerIterative3(ListNode head) {

        ListNode prev = null;

        //1->2->3->4->5
        while (head != null) {
            ListNode nextTmp = head.next;
            head.next = prev;

            prev = head;
            head = nextTmp;

        }
        return prev;

    }


    /**
     * Runtime : 0ms
     * Memory : 36.2Mb
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static ListNode reverseListMySolutionRecursive(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        System.out.println("bf head = " + head.val);

        ListNode newHead = reverseListMySolutionRecursive(head.next);

        System.out.println("start printing newHead");
        printListNode(newHead);
        System.out.println("end printing newHead");

        System.out.println("af head = " + head.val);

        head.next.next = head;
        head.next = null;

        return newHead;
    }


    public static ListNode reverseListIterativeSolution(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        //1->2->3->4->5
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static ListNode reverseListRecusriveSolution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseListRecusriveSolution(head.next);

        head.next.next = head;
        head.next = null;
        return p;
    }



}
