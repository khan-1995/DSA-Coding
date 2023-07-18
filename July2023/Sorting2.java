class Sorting2 {

	private static void quickSort(int[] arr, int low, int high) {

		if (low > high) {
			return;
		}

		int pivot = arr[low];
		int i = low;
		int j = high;

		// Put pivot in its postion
		while (i < j) {
			while (arr[i] < pivot && i <= high) {
				i++;
			}

			while (arr[j] > pivot && j >= low) {
				j--;
			}

			if (i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		//		printArray(arr);

		int pivotIndex = j;

		/ 																																														// Divide left and right arrays
			// Repeat same from left and right arrays
			quickSort(arr, low, pivotIndex - 1);
		quickSort(arr, pivotIndex + 1, high);
	}

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

			//		printArray(dest);
			System.out.print("\n");
		}

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
