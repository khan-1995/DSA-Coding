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

    private int sum = 0;
    public void sumHelper(TreeNode root,boolean isLeft){

        if(root==null){
            return;
        }

        if(isLeft && root.left==null && root.right==null){
            sum+=root.val;
        }

        sumHelper(root.left,true);
        sumHelper(root.right,false);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        sumHelper(root,false);

        return sum;
    }
}
