package leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber_10 {
    /**
     * Fibonacci Number
     *
     * The `Fibonacci numbers`, commonly denoted `F(n)` form a sequence, called the `Fibonacci sequence`, such that each
     * number is the sum of the two preceding ones, starting from `0` and `1`. That is,
     *
     *  F(0) = 0, F(1) = 1
     *  F(N) = F(N - 1) + F(N - 2), for N > 1.
     *
     * Given `N`, calculate F(N).
     *
     * Example 1:
     *
     *  Input: 2
     *  Output: 1
     *  Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
     *
     *
     * Example 2:
     *
     *  Input: 3
     *  Output: 2
     *  Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
     *
     *
     * Example 3:
     *
     *  Input: 4
     *  Output: 3
     *  Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
     *
     * Note:
     * 0 <= N <= 30.
     */


    public static void main(String[] args) {
//        System.out.println(fib(0));
//        System.out.println(fib(1));
//        System.out.println(fib(2));
//        System.out.println(fib(3));
//        System.out.println(fib(4));


//        System.out.println(fib2(0));
//        System.out.println(fib2(1));
//        System.out.println(fib2(2));
//        System.out.println(fib2(3));
//        System.out.println(fib2(4));

        System.out.println(fib3(0));
        System.out.println(fib3(1));
        System.out.println(fib3(2));
        System.out.println(fib3(3));
        System.out.println(fib3(4));
    }

    /**
     * 1st attempt
     * Recursive
     * Runtime : 155ms
     * Memory : 38.7Mb
     */
    public static int fib(int N) {

        Map<Integer, Integer> cache = new HashMap<>();

        if (cache.containsKey(N)) {
            return cache.get(N);
        }

        if (N == 0 || N == 1) {
            return N;
        }

        int prev = fib(N-1);
        int twoPrev = fib(N-2);

        cache.put(N-1, prev);
        cache.put(N-2, twoPrev);

        return prev + twoPrev;

    }

    /**
     * 2nd attempt : make cache to static
     * Recursive
     * Runtime : 0ms
     * Memory : 32.3Mb
     */
    static Map<Integer, Integer> cache = new HashMap<>();

    public static int fib2(int N) {

        if (cache.containsKey(N)) {
            return cache.get(N);
        }

        if (N == 0 || N == 1) {
            return N;
        }

        int prev = fib2(N-1);
        int twoPrev = fib2(N-2);

        cache.put(N-1, prev);
        cache.put(N-2, twoPrev);

        return prev + twoPrev;

    }


    /**
     * Iterative
     * Runtime : 0ms
     * Memory : 32.1Mb
     * Time complexity : O(n)
     */
    public static int fib3(int N) {
        if (N < 2) {
            return N;
        }

        int[] cache = new int[N];
        cache[0] = 0;
        cache[1] = 1;

        for (int i=2; i<N; i++) {
            cache[i] = cache[i-1] + cache[i-2];
        }

        return cache[N-1] + cache[N-2];
    }


}
