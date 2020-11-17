import java.util.*;

class HeapSort {

	public static void main(String[] args) {
		int[][] inputs = {
			{4,1,3,9,7},
			{4,10,3,5,1},
			{1,2,3,4},
			{7,6,5,4,3,2}
		};

		for(int[] arr : inputs) {
			HeapSort sorting = new HeapSort();
			System.out.println(Arrays.toString(arr));
			sorting.sort(arr, arr.length);
			System.out.println(Arrays.toString(arr));
			System.out.println();
		}

	}

	void sort(int[] arr, int n) {
        // Step 1 : building heap;
		buildHeap(arr, n);

        // Step 2 : reduce size of heap at every step
        for(int i = n - 1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;

            heapify(arr, i, 0);
        }
	}

    void buildHeap(int arr[], int n) {
        for(int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    void heapify(int arr[], int n, int i) {
        int left = (i * 2) + 1;
        int right = (i * 2) + 2;

        int max = i;
        if(right < n && arr[right] > arr[max])
            max = right;
        if(left < n && arr[left] > arr[max])
            max = left;
        if(max != i) {
            int tmp = arr[i];
            arr[i] = arr[max];
            arr[max] = tmp;
            heapify(arr, n, max);
        }

    }
}


