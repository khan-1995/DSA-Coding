class Solution {

	private int[] reverseArray(int[] arr,int start,int end){

		while(start < end){
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--; 
		}

		return arr;
	}

	public void nextPermutation(int[] nums) {
		int index = -1;
		int n = nums.length;

		//Find the dip point
		for(int i=n-2;i>=0;i--){
			if(nums[i] < nums[i+1]){
				index = i;
				break;
			}
		}

		if(index==-1){
			reverseArray(nums,0,n-1);
			return;
		}

		/*
		 * After finding the dip point
		 * find the next greater number to the dip point
		 * swap the both numbers 
		 * sort whatever the numbers are left after this     number 
		 */
		for(int j=n-1;j>index;j--){
			if(nums[j]>nums[index]){
				int temp = nums[j];
				nums[j] = nums[index];
				nums[index] = temp;
				break;
			}
		}

		reverseArray(nums,index+1,n-1);
	}
}
