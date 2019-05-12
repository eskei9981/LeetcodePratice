package Recursion;

public class PrincipalOfRecursion {

    /**

    Recursion is an approach to solving problems using a function that calls itself as a subroutine.

    You might wonder how we can implement a function that calls itself.
    The trick is that each time a recursive function calls itself, it reduces the given problem into subproblems.
    The recursion call continues until it reaches a point where the subproblem can be solved without further recursion.

    A recursive function should have the following properties so that it does not result in an infinite loop:
    - A simple base case (or cases) — a terminating scenario that does not use recursion to produce an answer.
    - A set of rules, also known as recurrence relation that reduces all other cases towards the base case.

    Note that there could be multiple places where the function may call itself.
     */


    /**
    EXAMPLE

    Print a string in reverse order.
     */

    public static void main(String[] args) {
//        printReverse("hello".toCharArray()); //olleh
//        reverseStringIterative("hello".toCharArray());

//        reverseStringRecursive("hello".toCharArray());


        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(4);

        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;

        ListNode head = node_1;

        printNode(head);
        ListNode newHead = swapPairs(head);
//        ListNode newHead = swapPairsIterative(head);
        printNode(newHead);


    }

    private static void printReverse(char [] str) {
        helper(0, str);
    }

    private static void helper(int index, char [] str) {
        if (str == null || index >= str.length) {
            return;
        }
        helper(index + 1, str);
        System.out.print(str[index]);
    }


    /**
    PRACTICE

    Reverse String

    Write a function that reverses a string. The input string is given as an array of characters char[].
    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

    You may assume all the characters consist of printable ascii characters.

    Example 1
    Input: ["h","e","l","l","o"]
    Output: ["o","l","l","e","h"]

    Example 2
    Input: ["H","a","n","n","a","h"]
    Output: ["h","a","n","n","a","H"]
     */


    public static void reverseStringIterative(char[] s) {
        int start = 0;
        int mid = s.length/2;
        int end = s.length - 1;

        while (start < mid) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;

            start++;
            end--;
        }

        printArray(s);

    }

    public static void printArray(char[] s) {
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i]);
        }
        System.out.println();
    }

    public static String reverseStringRecursive(char[] str) {
        printArray(str);

        reverseStringRecursive(0, str.length-1, str);

        printArray(str);

        return str.toString();
    }

    public static void reverseStringRecursive(int start, int end, char[] str) {
        if (start >= str.length/2) {
            return;
        }

//        System.out.println("start index = " + start);
        char tmp = str[start];
        str[start] = str[end];
        str[end] = tmp;

        start++;
        end--;

        reverseStringRecursive(start, end, str);

    }


    /**
     * PRACTICE
     *
     * Swap Nodes in Pairs
     *
     * Given a linked list, swap every two adjacent nodes and return its head.
     * You may not modify the values in the list's nodes, only nodes itself may be changed.
     *
     * Example
     * Given 1->2->3->4, you should return the list as 2->1->4->3.
     *
    */

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

//    public class ListNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    

    public ListNode swapPairsDiscuss(ListNode head) {
        if (head == null || head.next==null) {
            return head;
        }

        ListNode tempNext = head.next.next;
        ListNode tempFirst = head.next;
        ListNode tempSecond = head;

        head = tempFirst;
        head.next = tempSecond;
        head.next.next = swapPairsDiscuss(tempNext);

        return head;
    }

//    public ListNode swapPairs(ListNode head) {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode twoNextNode = head.next.next;

        //swap(node, node.next)
        ListNode tmpNode = head;
        head = head.next;
        head.next = tmpNode;

        head.next.next = swapPairs(twoNextNode);

        return head;
    }

    public static void printNode(ListNode head) {

        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            System.out.print("->");
            current = current.next;
        }

        System.out.println();
    }


}
