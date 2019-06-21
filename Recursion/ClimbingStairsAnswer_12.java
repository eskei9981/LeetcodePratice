package leetcode.recursion;

public class ClimbingStairsAnswer_12 {

    public static void main(String[] args) {
        System.out.println(climbStairs1(0));
        System.out.println(climbStairs1(1));
        System.out.println(climbStairs1(2));
        System.out.println(climbStairs1(3));
        System.out.println(climbStairs1(5));
    }


    /**
     * Summary
     *
     * You are climbing a stair case. It takes n steps to reach to the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     */

    /**
     * Solution
     *
     * Approach 1: Brute Force
     *
     * Algorithm
     * In this brute force approach we talk all possible combinations i.e. 1 and 2, at every step. At every step we are
     * calling the function `climbStairs` for step1 and 2, and return the sum of returned values of both functions.
     *  climbStairs(i,n) = (i+1,n) + climbStairs(i+2,n)
     * where i defines the current step and n defines the destination step.
     */


    public static int climbStairs1(int n) {
        return climb_Stairs1(0, n);
    }

    public static int climb_Stairs1(int i, int n) {
        if (i > n) {
            return 0;
        }

        if (i == n) {
            return 1;
        }
        return climb_Stairs1(i + 1, n) + climb_Stairs1(i + 2, n);
    }

    /**
     * Complexity Analysis
     * - Time complexity : O(2^n). Size of recursion tree will be 2^n.
     *   Recursiob tree for n=5 would be like this:
     *                                                  (0,5)
     *                            (1,5)                                (2,5)
     *                (2,5)               (3,5)                   (3,5)     (4,5)
     *           (3,5)   (4,5)      (4,5)       (5,5)          (4,5)(5,5) (5,5)(6,5)
     *      (4,5)(5,5) (5,5)(6,5) (5,5)(6,5)
     *
     *      Number of Nodes = O(2^n)
     *
     * - Space complexity : O(n). The depth of the recursion tree can go up to n
     *
     *
     * =================================================================================================
     */


    /**
     * Approach 2: Recursion with Memoization
     *
     * Algorithm
     * In the previous approach we are redundantly calculating the result for every step. Instead, we can store the
     * result at each step in `memo` array and directly returning the result from the `memo` array whenever that
     * function is called again.
     * In this way we are pruning recursion tree with the help of `memo` array and reducing the size of recursion tree
     * upto n.
     */

    public int climbStairs2(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs2(0, n, memo);
    }

    public int climb_Stairs2(int i, int n, int[] memo) {
        if (i > 0) {
            return 0;
        }

        if (i == n) {
            return 1;
        }

        if (memo[i] > 0) {
            return memo[i];
        }

        memo[i] = climb_Stairs2(i+1, n, memo) + climb_Stairs2(i+2, n, memo);
        return memo[i];
    }

    /**
     * Complexity Analysis
     * - Time complexity: O(n). Size of recursion tree can go upto n.
     * - Space complexity: O(n). The depth of recursiob tree can go to upto n.
     *
     * =================================================================================================
     */


    /**
     * Approach 3: Dynamic Programming
     *
     * Algorithm
     * As we can see this problem can be broken into subproblems, and it contains the optimal substructure property
     * i.e. its optimal solution can be constructed efficiently from optimal solutions of its subproblems, we can use
     * dynamic programming to solve this problem.
     *
     * One can reach i-th step in one of the two ways:
     *  1.Taking a single step from (i-1)th step.
     *  2.Taking a step of 2 from (i-2)th step.
     * So, the total number of ways reach i-th is equal to sum of ways of reaching (i-1)th step and ways of reaching
     * (i-2)th step.
     * Let dp[i] denotes the number of ways to reach on i-th step:
     *  dp[i] = dp[i-1] + dp[i-2]
     */

    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * Complexity Analysis
     * - Time complexity : O(n). Single loop upto n.
     * - Space complexity : O(n). `dp` array of size `n` is used.
     *  =================================================================================================
     */


    /**
     * Approach 4 : Fibonacci Number
     *
     * Algorithm
     * In the above approach we have used `dp` array where dp[i] = dp[i-1] + dp[i-2]. It can be easily analysed that
     * dp[i] is nothing but i-th fibonacci number.
     *  Fib(n) = Fib(n - 1) + Fib(n - 2)
     * Now we just have to find n-th number of the fibonacci series having 1 and 2 their first and second term
     * respectively, i.e. Fin(1) = 1 and Fib(2) = 2.
     */

    public int climbStairs4(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;

    }
    /**
     * =================================================================================================
     */


    /**
     * Approach 5 : Binets Method
     *
     * Algorithm
     * This is an interesting solution which uses matrix multiplication to obtain the n^th Fibonacci Number. The matrix
     * takes the following form:
     *
     *  |Fn+1   F| = |1 1|
     *  |Fn  Fn-1|   |1 0|
     *
     * Let's say Q = |Fn+1  Fn |
     *               |Fn   Fn-1|. As per the method, the n^th Fibonacci Number is given by Q^n-1[0,0].
     * Let's look at the proof of this method.
     * We can provide this method using Mathematical Induction. We know, this matrix gives the correct result for the
     * 3^rd term(base case). Since Q^2 = |2 1|
     *                                   |1 1|. This proves that the base case holds.
     * Assume that this method holds for finding the n^th Fibonacci Number, i.e. Fn = Q^n-1[0,0], where
     *  Q^n-1 = |Fn   Fn-1|
     *          |Fn-1 Fn-2|
     * Now, we need to prove that with the above teo conditions holding true, the method is valid for finding the
     * (n+1)^th Fibonacci Number, i.e. Fn+1 = Q^n[0,0].
     * Proof: Q^n = |Fn   Fn-1| |1 1| . Q^n = |Fn + Fn-1      Fn| Q^n = |Fn+1   Fn|
     *              |Fn-1 Fn-2| |1 0|         |Fn-1 + Fn-2  Fn-1|       |Fn   Fn-1|
     * Thus, Fn+1 = Q^n[0,0]. This completes the proof of this method.
     *
     * The only variation we need to do for our problem is that we need to modify the initial temrs to 2 and 1 instead
     * of 1 and 0 in the Fibonacci series. Or, another way is to use the same initial Q matrix and use result = Q^n[0,0]
     * to get the final result. This happens because the initial terms we have to use are the 2nd and 3rd terms of the
     * otherwise normal Fibonacci Series.
     */

    public int climbStairs5(int n) {
        int[][]q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }

    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }

    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }


    /**
     * Complexity Analysis
     * - Time complexity : O(logn). Traversing on log n bits.
     * - Space complexity : O(1). Constant space is used.
     *
     * Proof of Time Complexity:
     * Let's say there is a matrix M to be raise to power n. suppose, n is the power of 2. Thus, n = 2^i, i E N,
     * where N represents the set of natural numbers(including 0). We can represent in the form of a tree:
     *                    M^n
     *             M^n/2      M^n/2
     *                   ...
     *
     *           M^2    M^2  ...   M^2
     *        M^1 M^1 M^1 M^1 ... M^1 M^1
     * Meaning that: M^n = M^n/2.M^n/2 = .... = TTn M^1
     *                                          TT1
     * So, to calculate M^n matrix, we should calculate M^n/2 matrix and multiply it by itself. To calculate M^n/2 we
     * would have to do the same with Mn/4 and so on.
     *
     * Obviously, the tree height is log2n.
     * Let;s estimate M^n calculation time. M matrix is of the same size in any power. Therefore, we can perform the
     * multiplication of two matrices in any power in O(1). We should perform log2n of such multiplications. So, M^n
     * calculation complexity is O(log2n).
     *
     * In case, the number n is not a power of two, we can break it in terms of powers of 2 using its binary
     * representation:
     *      n = SIGMA2^p, where P ( N
     *          pEP
     * Thus, we can obtain the final result using:
     *      M^n = TTM^2^p
     *            pEP
     * This is the method we've used in our implementation. Again, the complexity remains O(log2n) as we have limited
     * the number of multiplications to O(log2n).
     *
     * =================================================================================================
     */



    /**
     * Approach 6 : Fibonacci Formula
     *
     * Algorithm
     * We can find n^th fibonacci number using this formula:
     *      Fn = 1/root5|(1+root5)^n - (1-root5)^n|
     *                  |(-------)     (-------)  |
     *                  |(   2   )     (   2   )  |
     * For the given problem, the Fibonacci sequence is defined by F0 = 1, F1 = 1, Fn+2 = Fn+1 + Fn.
     * A standard method of trying to solve such recursion formula is assume Fn of the form Fn = a^n. Then, of course,
     * Fn+1 = a^n+1 and Fn+2 = a^n+2 so the equation becomes a^n+2 = a^n+1 + a^n. If we divide the entire equation by n
     * we arrive at a^2 = a + 1 or the quadratic equation a^2 - a - 1 = 0.
     *
     * Solving this by the quadratic formula, we got:
     *      a = 1/root5((1 +- root5))
     *                 ((----------))
     *                 ((    2     ))
     * The general solution, thus takes the form:
     *      Fn = A(1 + root5)^n + B(1 - root5)^n
     *            (---------)      (---------)
     *            (    2    )      (    2    )
     *
     * For n = 0, we get A + B = 1
     * For n = 1, we get A(1 + root5) + B(1 - root5) = 1
     *                    (---------)    (---------)
     *                    (    2    )    (    2    )
     * Solving the above equations, we get:
     *      A = (1 + root5), B = (1 - root5)
     *          (---------)      (---------)
     *          ( 2root5  )      ( 2root5  )
     * Putting these values of A and B in the above general solution equation, we get:
     *      Fn = 1/root5((1+root5)^n+1 - (1-root5)^n+1)
     *                  ((-------)     - (-------)    )
     *                  ((   2   )       (   2   )    )
     */

    public int climbStairs6(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n+1) - Math.pow((1 - sqrt5) / 2, n+1);

        return (int) (fibn / sqrt5);
    }

    /**
     * Complexity Analysis
     * - Time complexity : O(logn). pow method takes logn time.
     * - Space complexity : O(1). Constant space is used.
     */





}
