package leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2_7 {

    /**
     * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
     *
     * Note that the row index starts from 0.
     *
     * In Pascal's triangle, each number is the sum of the two numbers directly above it.
     *
     * Example:
     *
     * Input: 3
     * Output: [1,3,3,1]
     * Follow up:
     *
     * Could you optimize your algorithm to use only O(k) extra space?
     *
     */


    //    1    <-0
    //   1,1   <-1
    //  1,2,1  <-2
    // 1,3,3,1 <-3
    public static void main(String[] args) {
//        printRow(getRow(3));
//        printRow(getRow2(3));
        printRow(getRow3(3));
    }

    public static void printRow(List<Integer> row) {
        System.out.print("[");
        for (int i : row) {
            System.out.print(i + ",");
        }

        System.out.print("]");
        System.out.println();

    }

    /**
     * Runtime : 1ms
     * Mmory : 33.1mb
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> prevRow = new ArrayList<>();
        int i = 0;
        while (i <= rowIndex) {
            List<Integer> row = new ArrayList<>();
            for (int j=0; j<=i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);

                } else {
                    row.add(prevRow.get(j-1) + prevRow.get(j));
                }
            }

            prevRow = row;

            i++;
        }

        return prevRow;
    }


    /**
     * Runtime : 1ms
     * Mmory : 32.7mb
     */
    public static List<Integer> getRow2(int rowIndex) {
        if (rowIndex == 0) {
            List<Integer> aRow = new ArrayList<>();
            aRow.add(1);
            return aRow;
        }

        int currentRowNum = 1;
        List<Integer> prevRow = new ArrayList<>();

        while (currentRowNum <= rowIndex) {
            List<Integer> aRow = new ArrayList<>();
            aRow.add(1);
            for (int i=1; i<=currentRowNum; i++) {
                if (currentRowNum == i) {
                    aRow.add(1);

                } else {
                    aRow.add(prevRow.get(i - 1) + prevRow.get(i));
                }
            }
            prevRow = aRow;
            currentRowNum ++;
        }

        return prevRow;
    }


    /**
     * Runtime : 1ms
     * Mmory : 32.8mb
     */
    public static List<Integer> getRow3(int rowIndex) {

        if (rowIndex <= 1) {
            List<Integer> aRow = new ArrayList<>();
            for (int i=0; i<=rowIndex; i++) {
                aRow.add(1);
            }
            return aRow;
        }

        int currentRowNum = 1;
        List<Integer> prevRow = new ArrayList<>();

        while (currentRowNum <= rowIndex) {
            List<Integer> aRow = new ArrayList<>();
            aRow.add(1);
            for (int i=1; i<=currentRowNum; i++) {
                if (currentRowNum == i) {
                    aRow.add(1);

                } else {
                    aRow.add(prevRow.get(i - 1) + prevRow.get(i));
                }
            }
            prevRow = aRow;
            currentRowNum ++;
        }

        return prevRow;
    }
}
