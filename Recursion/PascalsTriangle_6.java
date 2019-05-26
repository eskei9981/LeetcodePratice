package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_6 {

    /**
     * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
     *
     * In Pascal's triangle, each number is the sum of the two numbers directly above it.
     *
     * Example:
     *
     * Input: 5
     * Output:
     * [
     *     [1],
     *    [1,1],
     *   [1,2,1],
     *  [1,3,3,1],
     * [1,4,6,4,1]
     * ]
     */


    public static void main(String[] args) {
        printTriangle(generate(5));


    }

    public static void printTriangle(List<List<Integer>> triangle) {

        System.out.println("[");
        for (List<Integer> row : triangle) {
            System.out.print("[");
            for (int i : row) {
                System.out.print(i + ",");
            }
            System.out.print("]");
            System.out.println();
        }

        System.out.println("]");

    }

    /**
     * Iterative
     *
     * Runtime : 0ms
     * Memory : 33Mb
     *
     * Time complexity : O(n^2)
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> prevRow = new ArrayList<>();

        int i = 1;
        while (i <= numRows) {

            List<Integer> row = new ArrayList<>();

            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    row.add(1);

                } else {
                    row.add(prevRow.get(j - 2) + prevRow.get(j - 1));
                }
            }

            triangle.add(row);
            prevRow = row;

            i++;
        }

        return triangle;

    }

    /**
     * Recursive
     *
     * Time Limit Exceeded
     */
    public List<List<Integer>> generateRecursive(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        int i = 1;
        while (i <= numRows) {
            List<Integer> row = new ArrayList<>();

            for (int j=1; j<=i; j++) {
                row.add(getValue(i,j));
            }

            triangle.add(row);
            i++;
        }

        return triangle;
    }

    int getValue(int row, int column) {

        if (column == 1 || column == row) {
            return 1;
        }

        return getValue(row-1, column-1) + getValue(row-1, column);
    }

}


