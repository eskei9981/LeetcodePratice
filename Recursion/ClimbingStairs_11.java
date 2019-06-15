package leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs_11 {

    /**
     * You are climbing a stair case. It takes n steps to reach to the top.
     *
     * Each time you can either climb 1 or 2 steps. In how many distinct ways you climb to the top?
     *
     * Note: Given n will be a positive integer.
     *
     *
     * Example 1:
     *
     * Input: 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     *
     *
     * Example 2:
     *
     * Input: 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     *
     *
     * in:4
     * out:5
     *
     * 1. 1 + 1 + 1 + 1
     * 2. 1 + 1 + 2
     * 3. 1 + 2 + 1
     * 4. 2 + 1 + 1
     * 5. 2 + 2
     *
     */


    public static void main(String[] args) {

//        System.out.println(climbStairs(0)); //0
//        System.out.println(climbStairs(1)); //1
//        System.out.println(climbStairs(2)); //2
//        System.out.println(climbStairs(3)); //3
//        System.out.println(climbStairs(4)); //5

        System.out.println(climbStairsRecursive(0)); //0
        System.out.println(climbStairsRecursive(1)); //1
        System.out.println(climbStairsRecursive(2)); //2
        System.out.println(climbStairsRecursive(3)); //3
        System.out.println(climbStairsRecursive(4)); //5

    }

    /**
     * Iterative
     * Runtime : 0ms
     * Memory : 32.2Mb
     * Time complexity : O(n)
     * Space complexity : O(n)
     */
    public static int climbStairs(int n) {

        if (n < 3) {
            return n;
        }

        int[] cache = new int[n+1];
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;

        for (int i=3; i<=n; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }

        return cache[n];
    }


    /**
     * Recursive
     * Runtime : 1ms
     * Memory : 32.4Mb
     * Time complexity : O(2^n)
     */
    public static int climbStairsRecursive(int n) {

        Map<Integer, Integer> cache = new HashMap<>();

        cache.put(0, 0);
        cache.put(1, 1);
        cache.put(2, 2);

        return climbStairsRecursiveInternal(n, cache);

    }

    static int climbStairsRecursiveInternal(int n, Map<Integer, Integer> cache) {

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        cache.put(n-1, climbStairsRecursiveInternal(n-1, cache));
        cache.put(n-2, climbStairsRecursiveInternal(n-2, cache));

        return cache.get(n-1) + cache.get(n-2);

    }

}
