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

    private TreeNode helper(TreeNode root){
        if(root.left==null){
            return root.right;
        }else if(root.right==null){
            return root.left;
        }

        TreeNode right = root.right;
        TreeNode lastRight = root.left;
        while(lastRight.right!=null){
            lastRight = lastRight.right;
        }
        lastRight.right = right;

        return root.left;
    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root==null){
            return root;
        }

        if(root.val==key){
            return helper(root);
        }
        
        TreeNode cur = root;
        while(cur!=null){

            if(key>cur.val){
                if(cur.right!=null && cur.right.val==key){
                    cur.right = helper(cur.right);
                    break;
                }else{
                    cur = cur.right;
                }
            }else{
                if(cur.left!=null && cur.left.val==key){
                    cur.left = helper(cur.left);
                    break;
                }else{
                    cur = cur.left;
                }
            }

        }


        return root;
    }
}
