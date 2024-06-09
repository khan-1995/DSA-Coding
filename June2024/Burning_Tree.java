//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public static Node  populateParentMap(Node root, int target,Map<Node,Node> parentMap){
        
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node targetNode = null;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i=0;i<size;i++){
                
                Node node = q.poll();
                
                if(node.left!=null){
                    parentMap.put(node.left,node);
                    q.offer(node.left);
                }
                
                if(node.right!=null){
                    parentMap.put(node.right,node);
                    q.offer(node.right);
                }
                
                if(node.data==target){
                    targetNode = node;
                    break;
                }
            }
        }
        
        return targetNode;
    } 
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        Map<Node,Node> parentMap = new HashMap<>();
        
        int time = 0;
        
        Node targetNode = populateParentMap(root,target,parentMap);
        
        Set<Node> visited = new HashSet<>();
        
        Queue<Node> q = new LinkedList<>();
        q.offer(targetNode);
        visited.add(targetNode);
        // System.out.print(targetNode.data);
        // boolean isFound = false;
        // int flag = 0;
        while(!q.isEmpty()){
            
            int size = q.size();
            
           int flag = 0;
            for(int i=0;i<size;i++){
                
                Node node = q.poll();
                
                
                if(node.left!=null && !visited.contains(node.left)){
                    flag = 1;
                    visited.add(node.left);
                    q.offer(node.left);
                }
                
                if(node.right!=null && !visited.contains(node.right)){
                    flag = 1;
                    visited.add(node.right);
                    q.offer(node.right);
                }
                
                if(parentMap.get(node)!=null && !visited.contains(parentMap.get(node))){
                    flag = 1;
                    visited.add(parentMap.get(node));
                    q.offer(parentMap.get(node));
                }
                
            }
            
            if(flag==1){
                time++;
            }
        }
        
        return time;
    }
}
