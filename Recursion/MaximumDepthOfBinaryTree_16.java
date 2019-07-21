package leetcode.recursion;

public class MaximumDepthOfBinaryTree_16 {

    /**
     * Given a binary tree, find its maximum depth.
     *
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     *
     * Note: A leaf is a node with no children.
     *
     * Example:
     *
     * Given binary tree [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * return its depth = 3.
     *
     *
     */

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public static void main(String[] args) {
        TreeNode node_3 = new TreeNode(3);
        TreeNode node_9 = new TreeNode(9);
        TreeNode node_20 = new TreeNode(20);
        TreeNode node_15 = new TreeNode(15);
        TreeNode node_7 = new TreeNode(7);

        node_3.left = node_9;
        node_3.right = node_20;
        node_20.left = node_15;
        node_20.right = node_7;


        System.out.println(maxDepth(node_3));
        System.out.println(maxDepth(null));

        TreeNode node_11 = new TreeNode(11);
        System.out.println(maxDepth(node_11));



    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * Runtime : 0ms
     * Memory : 39MB
     */
    public static int maxDepth(TreeNode root) {
        return findLeaf(root, 0);
    }

    private static int findLeaf(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int leftDepth = findLeaf(root.left, depth+1);
        int rightDepth = findLeaf(root.right, depth+1);

        return Math.max(leftDepth, rightDepth);
    }
}
