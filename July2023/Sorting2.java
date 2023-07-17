class Sorting2 {

	private static void merge(int[] arr1, int[] arr2, int[] dest) {

		int i = 0;
		int j = 0;
		int dindex = 0;

		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] <= arr2[j]) {
				dest[dindex++] = arr1[i++];
			} else {
				dest[dindex++] = arr2[j++];
			}
		}

		while (i < arr1.length) {
			dest[dindex++] = arr1[i++];
		}

		while (j < arr2.length) {
			dest[dindex++] = arr2[j++];
		}

	}


	//Time complexity O(n log n )
	private static void mergeSort(int[] arr) {

		if (arr.length < 2) {
			return;
		}

		int mid = arr.length / 2;
		int[] left = new int[mid];
		int[] right = new int[arr.length - mid];

		System.arraycopy(arr, 0, left, 0, left.length);
		System.arraycopy(arr, mid, right, 0, right.length);

		mergeSort(left);
		mergeSort(right);

		merge(left, right, arr);

	}


}
