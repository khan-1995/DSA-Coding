class Solution {
	public int majorityElement(int[] nums) {

		/**
		 *     Input: nums = [3,2,3]
		 *         Output: 3 */
		if(nums.length == 1){
			return nums[0];
		}

		/**Better Approach*/
		HashMap<Integer,Integer> map  = new HashMap<>();
		int half_size = nums.length/2;

		for(int i=0;i<nums.length;i++){
			if(map.get(nums[i])!=null && map.get(nums[i]) >= half_size ){
				return nums[i];
			}else{
				Integer freq = map.get(nums[i]);
				if(freq == null){
					map.put(nums[i],1);
				}else{
					map.put(nums[i],freq+1);
				}
			}
		}

		/**Optimal Approach */
		int el = 0;
		int count = 0;

		for(int i=0;i<nums.length;i++){
			if(count == 0 ){
				el = nums[i];
				count = 1;
			}else if(nums[i] == el){
				count++;
			}else{
				count--;
			}
		}

		int check_count = 0;

		for(int j=0;j<nums.length;j++){
			if(nums[j] == el ){
				check_count++;
			}
		}

		if(check_count > half_size){
			return el;
		}


		return -1;
	}
}
