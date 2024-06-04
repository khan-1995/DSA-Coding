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
    public void populateParentMap(TreeNode root,Map<TreeNode,TreeNode> parentMap){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                TreeNode node  = q.poll();

                if(node.left!=null){
                    q.offer(node.left);
                    parentMap.put(node.left,node);
                }

                if(node.right!=null){
                    q.offer(node.right);
                    parentMap.put(node.right,node);
                }
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();

        populateParentMap(root,parentMap);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.add(target);
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();

            if(level==k){
                break;
            }

            level+=1;
            for(int i=0;i<size;i++){
                TreeNode node  = q.poll();

                if(node.left!=null && !visited.contains(node.left)){
                    q.offer(node.left);
                    visited.add(node.left);
                }

                if(node.right!=null && !visited.contains(node.right)){
                    q.offer(node.right);
                    visited.add(node.right);
                }

                if(parentMap.containsKey(node) && !visited.contains(parentMap.get(node))){
                    q.offer(parentMap.get(node));
                    visited.add(parentMap.get(node));
                }
            }
        }

        return q.stream().map(el -> el.val).toList();
    }
}
