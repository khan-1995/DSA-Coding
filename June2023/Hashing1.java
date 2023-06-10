/*Find the frequency ( Or ) repition of numbers in a given array*/
import java.util.Map;
import java.util.HashMap;

class Hashing1 {


	private static int[] findFrequencyArray(String str){
		if (str == null)
			return null;
		
		char[] charArray = str.toCharArray();
		int[] frequency = new int[26];

		for(char ch : charArray ){
			frequency[ch-97] += 1;
		}
		
		for(int i : frequency)
			System.out.print(i+",");

      return frequency;
	}

	private static Map<Character, Integer> findFrequency(String str) {
		/* Code to added here */
		if (str == null)
			return null;
		Map<Character, Integer> char2frequency = new HashMap<>();
		char[] chars = str.toCharArray();

		for (Character ch : chars) {
			if (char2frequency.containsKey(ch)) {
				char2frequency.put(ch, char2frequency.get(ch) + 1);
			} else {
				char2frequency.put(ch, 1);
			}
		}

		System.out.println(char2frequency);

		return char2frequency;
	}

	public static void main(String[] args) {
		findFrequency("aabbskfjsfkwewe");
		/*output : {a=2, b=2, s=2, e=2, f=2, w=2, j=1, k=2}*/

		findFrequencyArray("aabbskfjsfkwewe");
		/*output : 2,2,0,0,2,2,0,0,0,1,2,0,0,0,0,0,0,0,2,0,0,0,2,0,0,0, */

	}

}
