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

    private TreeNode constructBST(int[] arr,int[] index,int upper_bound){
        if(index[0]>=arr.length || arr[index[0]]>upper_bound){
            return null;
        }

        TreeNode root = new TreeNode(arr[index[0]++]);

        root.left = constructBST(arr,index,root.val);
        root.right = constructBST(arr,index,upper_bound);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder,new int[]{0},Integer.MAX_VALUE);
    }
}
