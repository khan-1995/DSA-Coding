ass Solution {
	public int subarraySum(int[] nums, int k) {

		int n = nums.length;
		int count = 0;
		HashMap<Integer,Integer> map = new HashMap<>();
		//Better aproach brute force O(n ^ 2)
		for(int i=0;i<n;i++){
			int sum = 0;
			for(int j=i;j<n ;j++){
				sum+=nums[j];
				if(sum > k){
					break;
				}
				if(sum == k){
					count++;
				}
			}
		}
		int prefix_sum = 0;
		//prefix sum
		map.put(0,1);
		//Optimal O(n) or O(n log n) 
		for(int i=0;i<n;i++){
			prefix_sum+=nums[i];

			int balance = prefix_sum - k;

			count += map.getOrDefault(balance, 0);

			map.put(prefix_sum, map.getOrDefault(prefix_sum, 0) + 1);
		}

		return count;

	}
}
