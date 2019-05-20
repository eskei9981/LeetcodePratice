package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    /**
     * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
     *
     * In Pascal's triangle, each number is the sum of the two numbers directly above it.
     *
     * Example:

     Input: 5
     Output:
     [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
     ]
     */

    public static void main(String[] args) {
        List<List<Integer>> list = generate(5);
        printList(list);


    }

    public static void printList(List<List<Integer>> list) {
        System.out.print("[");
        System.out.println();

        for (List<Integer> l : list) {
            System.out.print("[");
            for (Integer i : l) {
                System.out.print(i + ",");
            }
            System.out.print("]");
            System.out.println();
        }

        System.out.print("]");

    }

    /*
    [
         [1],
        [1,1],
       [1,2,1],
      [1,3,3,1],
     [1,4,6,4,1]
     ]
     */
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> prevRow = new ArrayList<>();
        int i = 1;
        while (i <= numRows) {
            List<Integer> aRow = new ArrayList<>();

            for (int j=1; j<=i; j++) {
                if (j == 1 | i == j) {
                    aRow.add(1);

                } else {
                    aRow.add(prevRow.get(j-2) + prevRow.get(j-1));
                }
            }
            prevRow = aRow;

            triangle.add(aRow);
            i++;
        }
        return triangle;
    }

    public static void printARow(List<Integer> list) {
        System.out.print("[");
        for (Integer i : list) {
            System.out.print(i + ",");

        }
        System.out.print("]");
        System.out.println();

    }
}
