class Solution {
	/**
	 *     Input: nums = [2,0,2,1,1,0]
	 *         Output: [0,0,1,1,2,2]
	 *             */
	public void swap(int[] nums,int i,int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public void sortColors(int[] nums) {

		int low = 0;
		int mid = 0;
		int high = nums.length-1;

		while( mid <= high ){
			//Case when mid is 0
			if(nums[mid] == 0){
				swap(nums,low,mid);
				low++;
				mid++;
			}else if(nums[mid]==1){
				//Case when mid is 1
				mid++;
			}else{
				//Case when mid is 2
				swap(nums,mid,high);
				high--;
			}
		}

	}
}
