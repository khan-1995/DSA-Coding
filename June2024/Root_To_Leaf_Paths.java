

/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer>path = new ArrayList<Integer>();
        
        if(root == null) return ans;
        
        allPaths(root,ans,path);
        return ans;
        
    }
    private static void allPaths(Node root,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> path){
        
        if(root == null) return;
        
        path.add(root.data);
        
        if(root.left == null && root.right == null){
            ans.add(new ArrayList<>(path));
        }
        if(root.left != null){
            allPaths(root.left,ans,new ArrayList<>(path));
        
        }
        if(root.right != null){
            allPaths(root.right,ans,new ArrayList<>(path));
        }

    }
}
        
