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

    private int d = 0;
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftH = height(root.left);
        int rightH = height(root.right);
        d = Math.max((leftH+rightH),d);

        return 1+Math.max(leftH,rightH);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }

        height(root);

        return d;
    }
}
