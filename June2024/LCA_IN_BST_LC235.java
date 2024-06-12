/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    // For normal Binary tree
    // private TreeNode lca(TreeNode root,TreeNode p,TreeNode q){
    //     if(root==null || root==p || root==q){
    //         return root;
    //     }


    //     TreeNode left = lca(root.left,p,q);

    //     TreeNode right = lca(root.right,p,q);

    //     if(left==null){
    //         return right;
    //     }else if(right==null){
    //         return left;
    //     }


    //     return root;
    // }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return root;
        }
        // return lca(root,p,q);
        int curr = root.val;
        if(curr < p.val && curr < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }

        if(curr > p.val && curr > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }

        return root;
    }
}
