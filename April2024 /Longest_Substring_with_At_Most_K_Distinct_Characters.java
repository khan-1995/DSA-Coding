import java.util.*;
public class Solution {

	public static int kDistinctChars(int k, String s) {
		// Write your code here

		Map<Character,Integer> map = new HashMap<>();

		int left = 0;

		int len = 0;

		for(int right = 0;right<s.length();right++){
			map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);

			while(map.size()>k){
				map.put(s.charAt(left),map.get(s.charAt(left))-1);
				if(map.get(s.charAt(left))==0){
				 map.remove(s.charAt(left));    
				}
				left++;
			}

			len =  Math.max(len,(right-left)+1);
		}

		return len;
	}
	
	public static void main(String[] args){
	    String str = "abcddefg";
	    int k = 3;
      // Output 4 -> cdde , ddef 
	    
	    System.out.print(Solution.kDistinctChars(k,str));
	    
	}

}
