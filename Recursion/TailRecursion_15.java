package leetcode.recursion;

public class TailRecursion_15 {
    /**
     * In this previous article, we talked about the implicit extra space incurred on the system stack due to recursion
     * calls. However, you should learn to identify a special case of recursion called `tail recursion`, which is
     * exempted from this space overhead.
     *
     *  Tail recursion is a recursion where the recursive call is the final instruction in the recursion function. And
     *  there should be only one recursive call in the function.
     *
     * We have already seen an example of tail recursion in the solution of `Reverse String`. Here is another example
     * that shows the difference between non-tail-recursion and tail-recursion. Notice that in the non-tail-recursion
     * example there is an extra computation after the vary last recursive call.
     */

    public static void main(String[] args) {
//        int[] ls = new int[]{0, 1, 2};
        int[] ls = new int[]{2, 1, 5};

        System.out.println(sum_tail_recursion(ls));
        System.out.println(sum_non_tail_recursion(ls));
    }



    private static int helper_non_tail_recursion(int start, int[] ls) {
        if (start >= ls.length) {
            return 0;
        }

        // not a tail recursion because it does computation after the recursive call returned.
        return ls[start] + helper_non_tail_recursion(start + 1, ls);
    }

    public static int sum_non_tail_recursion(int[] ls) {
        if (ls == null || ls.length == 0) {
            return 0;
        }

        return helper_non_tail_recursion(0, ls);
    }


    private static int helper_tail_recursion(int start, int[] ls, int acc) {
        if (start >= ls.length) {
            return acc;
        }

        return helper_tail_recursion(start + 1, ls, acc + ls[start]);
    }

    public static int sum_tail_recursion(int[] ls) {
        if (ls == null || ls.length == 0) {
            return 0;
        }
        return helper_tail_recursion(0, ls, 0);
    }


    /**
     * The benefit of having tail recursion is that it could avoid the accumulation of stack overheads during the
     * recursive calls, since the system could reuse a fixed amount space in the stack for each recursive call.
     *
     * For example, for the sequence of recursion calls `f(x1) -> f(x2) -> f(x3)`, if the function `f(x)` is implemented
     * as tail recursion, then here is the sequence of execution steps along with the layout of the stack:
     *
     *
     * Note that in tail recursion, we know that as soon as we return from the recursive call we are going to
     * immediately return as well, so we can skip the entire chain of recursive calls returning and return straight to
     * the original caller. That means we don't need a call stack at all for all of the recursive calls, which saves us
     * space.
     *
     * For example, in step(1), a space in the stack would be allocated for `f(x1)` in order to call `f(x2)`. Then in
     * step(2), the function `f(x2)` would recursively call `f(x3)`. However, instead of allocating new space on the
     * stack, the system could simply reuse the space allocated earlier for this second recursion call. Finally, in the
     * function `f(x2)`, we reach the base case, and the function could simply return result to the original caller
     * without going back to the previous function calls.
     *
     * A tail recursion function can be executed as non-tail-recursion functions,i.e. with piles of call stacks, without
     * impact on the result. Often, the compiler recognizes tail recursion pattern, and optimizes its execution.
     * However, not all programming languages support this optimization. For instance, C,C++ support the optimization of
     * tail recursion functions. On the other hand, Java and Python do not support tail recursion optimization.
     */




}
