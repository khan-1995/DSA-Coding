/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root==null){
            return "null";
        }

        Queue<TreeNode> q = new LinkedList<>();
        // StringBuilder sb = new StringBuilder();

        q.offer(root);
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(root.val));
        while(!q.isEmpty()){

            int size  = q.size();

            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                
                if(node.left!=null){
                    list.add(String.valueOf(node.left.val));
                    q.offer(node.left);
                }else{
                    list.add("null");
                }

                if(node.right!=null){
                    list.add(String.valueOf(node.right.val));
                    q.offer(node.right);
                }else{
                    list.add("null");
                }
            }
        }

        return String.join(",",list.toArray(new String[list.size()]));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.print(data);
        if(data.equals("null")){
            return null;
        }

        String[] nodes = data.split(",");

        int height = nodes.length/2;
        int index = 0;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]),null,null);

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(index<height){

            TreeNode node = q.poll();

            String leftVal = nodes[2*index+1];
            String rightVal = nodes[2*index+2];

            if(!leftVal.equals("null")){
                TreeNode leftnode = new TreeNode(Integer.parseInt(leftVal),null,null);
                node.left = leftnode;
                q.offer(leftnode);
            }

            if(!rightVal.equals("null")){
                TreeNode rightnode = new TreeNode(Integer.parseInt(rightVal),null,null);
                node.right = rightnode;
                q.offer(rightnode);
            }
            index++;
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
