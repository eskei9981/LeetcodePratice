package leetcode.recursion;

public class SpaceComplexity_14 {
    /**
     * Recursion Related
     *
     *
     * In this article, we will talk about how to analyze the space complexity of a recursive algorithm.
     *
     * There are mainly two parts of the space consumption that one should bear in mind when calculating the space
     * complexity of a recursive algorithm: `recursion related` and `non-recursion related space`.
     *
     *
     * Recursion Related Space
     * The recursion related space refers to the memory cost that is incurred directly by the recursion, i.e. the stack
     * to keep track of recursive function calls. In order to complete a typical function call, the system allocates
     * some space in the stack to hold three important pieces of information:
     *
     *  1. The returning address of the function call. Once the function call is complete, the program must know where
     *     to return to, i.e. the line of code after the function call.
     *  2. The parameters that are passed to the function call.
     *  3. The local variables within the function call.
     *
     * This space in the stack is the minimal cost that is incurred during a function call. However, once the function
     * call is done, this space is freed.
     *
     * For recursive algorithms, the function calls chain up successively until they reach a `base case`(a.k.a. bottom
     * case). This implies that the space that is used for each function call is accumulated.
     *
     *  For a recursive algorithm, if there is no other memory consumption, then this recursion incurred space will be
     *  the space upper-bound of the algorithm.
     *
     * For example, in the exercise of `printReverse`, we don't have extra memory usage outside the recursive call,
     * since we simply print a character. For each recursive call, let's assume it can use space up to a constant value.
     * And the recursive calls will chain up to `n` times, where `n` is the size of the input string. So the space
     * complexity of this recursive algorithm is O(n).
     *
     * To illustrate this, for a sequence of recursive calls `f(x1) -> f(x2) -> f(x3)`, we show the sequence of
     * execution steps along with the layout of the stack:
     *
     * A space in the stack will be allocated for `f(x1)` in order to call `f(x2)`. Similarly in `f(x2)`, the system
     * will allocate another space for the call to `f(x3)`. Finally in `f(x3)`, we reach the base case, therefore there
     * is no further recursive call within `f(x3)`.
     *
     * It is due to recursion-related space consumption that sometimes one might run into a situation called stack
     * overflow, where the stack allocated for a program reaches its maximum space limit and the program crashes.
     * Therefore, when designing a recursive algorithm, one should carefully check if there is a possibility of stack
     * overflow when the input scales up.
     */


    /**
     * Non-Recursion Related Space
     *
     *
     * As suggested by the name, the non-recursion related space refers to the memory space that is not directly related
     * to recursion, which typically included the space (normally in heap) that is allocated for the global variables.
     *
     * Recursion or not, yuo might need to store the input of the problem as global variables, before any subsequent
     * function calls. And you might need to save the intermediate results from the recursive calls as well. The latter
     * is also known as `memoization` as we saw the previous chapter. For example, int he recursive algorithm with
     * memoization to solve the Fibonacci number problem, we used a map to keep track of all intermediate Fibonacci
     * numbers that occurred during the recursive calls. Therefore, in the space complexity analysis, we must take the
     * space cost incurred by the memoization into consideration.
     */


}
