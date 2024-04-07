class Solution {
  /*
  Input: s = "(*)"
  Output: true

  Input: s = "(*))"
  Output: true
  */
    public boolean checkValidString(String s) {

        // Stack<Integer> stack = new Stack<>();

        int leftMin = 0,leftMax = 0;
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                leftMin+=1;
                leftMax+=1;
            }else if(ch==')'){
                leftMin-=1;
                leftMax-=1;
            }else{
                leftMin-=1;
                leftMax+=1;
            }

            if(leftMax<0){
                return false;
            }

            leftMin = Math.max(0,leftMin);

            // if(ch==')'){
            //     if(!stack.isEmpty() && s.charAt(stack.peek())=='('){
            //         stack.pop();
            //     }else{
            //         stack.push(i);
            //     }
            // }

            // if(ch=='('){
            //     stack.push(i);
            // }

        }

        // int j = 0;
        // while(!stack.isEmpty() && j<s.length()){
        //     char ch = s.charAt(j);

        //     if(ch=='*'){
        //         if(j > stack.peek() && s.charAt(stack.peek())=='('){
        //             stack.pop();
        //         }else if(j < stack.peek() && s.charAt(stack.peek())==')'){
        //             stack.pop();
        //         }
        //     }
        //     j++;
        // }

        return leftMin==0;
    }
}
