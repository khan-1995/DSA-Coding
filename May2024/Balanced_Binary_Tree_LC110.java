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

    private int height(TreeNode n){
        if(n == null){
            return 0;
        }
        int left_height = height(n.left);
        int right_height = height(n.right);
        int diff = Math.abs(left_height - right_height);

        if(left_height==-1 || right_height==-1){
            return -1;
        }

        if(diff > 1){
            return -1;
        }

        return Math.max(left_height,right_height)+1;
    }

    public boolean isBalanced(TreeNode root) {

        if(root == null){
            return true;
        }

        int height = height(root);

        return height!=-1; 
    }
}
