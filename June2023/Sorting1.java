class Sorting1 {
    /**Selection sort  O(n^2)*/
   private static int[] doSelectionSort(int[] arr) {

		if (arr == null || arr.length == 1) {
			return arr;
		}

		for (int i = 0; i <= arr.length - 2; i++) {
			int min = i;
			int temp = 0;
			for (int j = i + 1; j <= arr.length - 1; j++) {
				if (arr[j] < arr[i]) {
					/** Swap the two indexes */
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;					
				}
			}
		}

		return arr;
	}

	/**Bubble sort O(n^2) */
	

	/**Insertion sort*/
	private static int[] doInsertionSort(int[] arr) {

		if (arr == null || arr.length == 1) {
			return arr;
		}

		for (int i = 0; i <= arr.length - 1; i++) {
		}

		return arr;
	}


    public static void main(String[] args){
        int[] num_arr = new int[]{13,46,23,52,20,9,17};
        System.out.println("Sorted Array >> ",doSelectionSort(num_arr));
    }
    
}