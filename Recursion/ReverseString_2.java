package leetcode.recursion;

public class ReverseString_2 {
    /**
     * Write s function that reverse a string. The input string is given as an array of characters `char[]`.
     *
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1)
     * extra memory.
     *
     * You must assume all the characters consists of printable ascii characters.
     *
     * Example 1:
     *
     * Input: ["h","e","l","l","o"]
     * Output: ["o","l","l","e","h"]
     * Example 2:
     *
     * Input: ["H","a","n","n","a","h"]
     * Output: ["h","a","n","n","a","H"]
     */

    public static void main(String[] args) {
        char[] input = new char[]{'h','e','l','l','o'};

//        reverseStringIterative(input);

//        reverseStringRecursive(input);

        reverseStringIterative2(input);

        printCharArr(input);


    }

    public static void printCharArr(char[] input) {
        for (char c : input) {
            System.out.print(c + ", ");
        }
        System.out.println();

    }

    /**
     * Iterative
     * runtime: 1ms
     * memory: 47.3MB
     */
    public static void reverseStringIterative(char[] s) {
        int mid = s.length/2;
        int end = s.length-1;

        int i = 0;
        while (i < mid) {
            swap(s, i, end-i);
            i++;
        }

    }

    private static void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    /**
     * Iterative
     * runtime: 1ms
     * memory: 50.4MB
     * Time complexity: O(n)
     */
    public static void reverseStringIterative2(char[] s) {
        int start = 0;
        int mid = s.length/2;
        int end = s.length - 1;

        while (start < mid) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;

            start ++;
            end --;
        }

    }


    /**
     * Recursive
     * runtime: 2ms
     * memory: 53.4MB
     * Time complexity: O(n)
     */
    public static void reverseStringRecursive(char[] s) {
        reverseStringRecursiveByIndex(s, 0);
    }

    private static void reverseStringRecursiveByIndex(char[] s, int i) {
        if (i == s.length/2) {
            return;
        }

        reverseStringRecursiveByIndex(s, i+1);
        swap(s, i, s.length-i-1);
    }


}
