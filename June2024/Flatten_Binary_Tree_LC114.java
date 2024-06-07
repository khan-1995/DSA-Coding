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
    TreeNode prev = null;
    public void traverse(TreeNode root){
        if(root==null){
            return;
        }

        traverse(root.right);
        traverse(root.left);
        
        root.right = prev;
        root.left = null;
        prev = root;

        return;
    }

    public void flatten(TreeNode root) {

        if(root==null){
            return;
        }

        traverse(root);
    }
}
