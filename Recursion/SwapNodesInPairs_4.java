package leetcode.recursion;

public class SwapNodesInPairs_4 {

    /**
     * Given a linked list, swap every two adjacent nodes and return its head.
     *
     * You may not modify the values in the list's nodes, only nodes itself may be changed.
     *
     * Example:
     * Given 1->2->3->4, you should return the list as 2->1->4->3
     */


    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    public static void main(String[] args) {

        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(4);
        ListNode node_5 = new ListNode(5);
        ListNode node_6 = new ListNode(6);
        ListNode node_7 = new ListNode(2);
        ListNode node_8 = new ListNode(2);
        ListNode node_null = null;

//        node_1.next = node_2;
//        node_2.next = node_3;
//        node_3.next = node_4;

        node_2.next = node_5;
        node_5.next = node_3;
        node_3.next = node_4;
        node_4.next = node_6;
        node_6.next = node_7;
        node_7.next = node_8;

//        printNodeList(swapPairs(node_1));
//        printNodeList(swapPairs(node_null));
//        printNodeList(swapPairs(node_1));
//        printNodeList(swapPairsIterative(node_2));

//        printNodeList(swapPairsRecursive(node_2));

        printNodeList(swapPairsRecursive2(node_2));

    }

    public static void printNodeList(ListNode head) {

        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("null");
        System.out.println();

    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * Iterative
     * Runtime : 0ms
     * Memory : 33.7mb
     */
    public static ListNode swapPairsIterative(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        ListNode swapedHead = null;

        swapedHead = swap(head, head.next);
        newHead = swapedHead;

        head = head.next;


        while (head != null && head.next != null) {
            swapedHead.next.next = swap(head, head.next);
            swapedHead  = swapedHead.next.next;
            head = head.next;
        }

        return newHead;
    }

    public static ListNode swap(ListNode head, ListNode next) {

        ListNode tmp = head.next;

        head.next = head.next.next;
        tmp.next = head;

        return tmp;
    }


    /**
     * Recursive
     * Runtime : 0ms
     * Memory : 33.7mb
     */
    public static ListNode swapPairsRecursive(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        System.out.println("head.val=" + head.val);

        ListNode newHead = head.next;

        swap(head, head.next);
        head.next = swapPairsRecursive(head.next);

        return newHead;
    }


    /**
     * Recursive
     * Runtime : 0ms
     * Memory : 33.4mb
     */
    public static ListNode swapPairsRecursive2(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode twoNextNode = head.next.next;

        ListNode tmp = head;
        head = head.next;
        head.next = tmp;

        head.next.next = swapPairsRecursive2(twoNextNode);

        return head;

    }

}

