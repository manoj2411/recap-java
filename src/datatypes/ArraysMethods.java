import java.util.*;

class ArraysMethods {
	public static void main(String[] args) {

		/*	Arrays.fill(arr, val)	*/
		int arr[] = new int[5];
		Arrays.fill(arr, 100);
		System.out.println(Arrays.toString(arr));

		/*	Arrays.equals(arr1, arr2)	*/
		int[] arr1 = { 1,5,7,11};
		int[] arr2 = { 1,5,7,11};
		System.out.println(Arrays.equals(arr1, arr2) + " vs " + (arr1 == arr2));

		/*	Arrays.binarySearch(arr, val)	*/
		System.out.println(Arrays.binarySearch(arr1, 1)); 	// 0
		System.out.println(Arrays.binarySearch(arr1, 11)); 	// 3
		System.out.println(Arrays.binarySearch(arr1, 7)); 	// 2

		// index of the search key; otherwise, (-(insertion point) - 1).
		// the index of the first element greater than the key,
		//  or a.length if all elements in the array are less than the specified key.
		System.out.println(Arrays.binarySearch(arr1, 0)); 	// -1
		System.out.println(Arrays.binarySearch(arr1, 2)); 	// -2
		System.out.println(Arrays.binarySearch(arr1, 4)); 	// -2
		System.out.println(Arrays.binarySearch(arr1, 6)); 	// -3
		System.out.println(Arrays.binarySearch(arr1, 8)); 	// -4
		System.out.println(Arrays.binarySearch(arr1, 18)); 	// -5
	}
}
