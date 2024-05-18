/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int moves = 0;

    public int[] dfs(TreeNode root){

        if(root==null){
            return new int[]{0,0};
        }

        int[] left_d = dfs(root.left);
        int[] right_d = dfs(root.right);

        int size = 1 + left_d[0] + right_d[0];
        int coins = root.val + left_d[1] + right_d[1];
        moves += Math.abs(size - coins);

        return new int[]{size,coins};

    }
    public int distributeCoins(TreeNode root) {
        dfs(root);

        return moves;     
    }
}
