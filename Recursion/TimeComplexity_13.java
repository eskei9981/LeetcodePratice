package leetcode.recursion;

public class TimeComplexity_13 {
    /**
     * https://leetcode.com/explore/featured/card/recursion-i/256/complexity-analysis/1669/
     *
     * Given a recursion algorithm, its time complexity O(T) is typically the product of `the number of recursion
     * invocations` (denoted as R) and `the time complexity of calculation` (denoted as O(s)) that incurs along with
     * each recursion call:
     *
     *      O(T) = R*O(s)
     */

    /**
     * Example
     *
     * As you might recall, in the problem of `printReverse`, we are asked to print the string in the reverse order. A
     * recurrence relation to solve the problem can be expressed as follows:
     *      printReverse(str) = printReverse(str[1...n]) + print(str[0])
     * where `str[1...n]` is the substring of the input string `str`, without the leading character `str[0]`.
     *
     * As you can see, the function would be recursively invoked `n` times, where `n` is the size of the input string.
     * At the end of each recursion, we simply print the leading character, therefore the time complexity of this
     * particular operation is constant, i.e. O(1).
     *
     * To sum up, the overall time complexity of our recursive funtion `printReverse(str)` would be
     * O(printReverse) = n * O(1) = O(n),
     */

    /**
     * Execution Tree
     *
     * For recursive functions, it is rarely the case that the number of recursion calls happens to be linear to the
     * size of input. For example, one might recall the example of `Fibonacci number` that we discussed in the previous
     * chapter, whose recurrence relation is defined as `f(n) = f(n-1) + f(n-2)`. At first glance, it does not seem
     * straightforward to calculate the number of recursion invocations during the execution of the Fibonacci function.
     *
     * In this case, it is better resort to the `execution tree`, which is a tree that is used to denote the execution
     * flow of a recursion function in particular. Each node in the tree represents an invocation of the recursive
     * function. Therefore, the total number of nodes in the tree corresponds to the number of recursion calls during
     * the execution.
     *
     * The execution tree of a recursive function would from an `n-ary tree`, with `n` as the number of times recursion
     * appears in the recurrence relation. For instance, the execution of the Fibonacci function would form a `binary
     * tree`, as one can see from the following graph which shows the execution tree for the calculation of Fibonacci
     * number `f(4)`
     *
     * 0 1 1 2 3
     *         ^
     *        f(4)
     *
     * Compute the 5th Fibonacci number : f(4)
     *
     *               f(4)
     *        f(3)         f(2)
     *    f(2)     f(1)  f(1) f(0)
     * f(1)f(0)
     *
     * In a full binary tree with `n` levels, the total number of nodes would be 2^n - 1. Therefore, the upper bound
     * (though not tight) for the number of recursion in `f(n)` would be 2^n - 1, as well. As a result, we can estimate
     * that the time complexity for `f(n)` would be O(2^n).
     */


    /**
     * Memoization
     *
     * In the previous chapter, we discussed the technique of memoization that is often applied to optimize the time
     * complexity of recursion algorithms. By caching and reusing the intermediate results, memoization can greatly
     * reduce the number of recursion calls, i.e. reducing the number of branches in the execution tree. One should take
     * this reduction into account when analyzing the time complexity of recursion algorithms with memoization.
     *
     * Let's get back to our example of Fibonacci number. With memoization, we save the result of Fibonacci number for
     * each index `n`. We are assured that the calculation for each Fibonacci number would occur only once. And we know,
     * from the recurrence relation, the Fibonacci number `f(n)` would depend on all `n-1` precedent Fibonacci numbers.
     * As a result, the recursion to calculate `f(n)` would be invoked `n-1` times to calculate all the precedent
     * numbers that it depends on.
     *
     * Now, we can simply apply the formula we introduced in the beginning of this chapter to calculate the time
     * complexity, which is O(1) * n = O(n). Memoization not only optimizes the time complexity of algorithm, but also
     * simplifies the calculation of time complexity.
     *
     * In the next article, we will talk about how to evaluate the space complexity of recursion algorithm.
     */
}
