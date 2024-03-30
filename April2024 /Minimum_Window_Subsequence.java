public class Solution {
    
    public static String minWindow(String S, String T) {
        // Write your code here
        int t_len = T.length();

        int left = 0;
        int k = 0;
        int len = Integer.MAX_VALUE;
        String str = "";

        for(int right=0;right<S.length();right++){
            char c = S.charAt(right);
            
            if(c == T.charAt(k)){
                k++;
            }

            if(k==t_len){

                left = right;
                k = t_len-1;

                while(left>=0 && k>=0){

                    if(S.charAt(left) == T.charAt(k)){
                           k--;
                    }

                    left--;
                }
                // System.out.println(S.charAt(left));

                left++;

                if((right-left)+1 < len){
                    len = (right-left)+1;
                    str = S.substring(left,len+1);
                }
                k=0;
                // right = left+1;
                
            }

        }
        
        return str;
    }
    
    public static void main(String[] args){
        String s = "abcdebdde";
        String t = "bde";
        
        System.out.print(Solution.minWindow(s,t));
        
    }
}
