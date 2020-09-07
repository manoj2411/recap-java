public class ImageOverlap {

	public static void main(String[] args) {
		// int[][] A = {{1,1,0},{0,1,0},{0,1,0}};
		// int[][] B = {{0,0,0},{0,1,1},{0,0,1}};
		// 3
		// int[][] A = {{1,0,0,1,0},{0,1,0,0,1},{1,0,1,1,0},{0,1,0,1,0},{1,1,1,0,1}};
		// int[][] B = {{1,1,1,0,0},{1,0,1,0,0},{1,1,1,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		// 6
		int[][] A = {{1,0,0,1,0},{0,1,0,0,1},{1,0,1,1,0},{0,1,0,1,0},{1,1,0,0,1}};
		int[][] B = {{1,1,1,0,0},{1,0,1,0,0},{1,1,1,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		// 5
		ImageOverlap obj = new ImageOverlap();
		System.out.println("Result: " + obj.largestOverlap(A, B));
	}

	public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        int max = 0;

        for (int i = 0; i < N; i++) {
        	for (int j = 0; j < N; j++) {
        		int currMax;
        		currMax = slidingOverlaps(A, B, N, i, j);
        		max = Math.max(max, currMax);

        		currMax = slidingOverlaps(B, A, N, i, j);
        		max = Math.max(max, currMax);
        	}
        }
        return max;
    }

    int slidingOverlaps(int[][] A, int[][] B, int N, int slidei, int slidej) {
    	int count = 0;
    	for (int i = 0; i + slidei < N; i++) {
    		for (int j = 0; j + slidej < N; j++) {
    			if(A[i+slidei][j+slidej] == 1 && B[i][j] == 1)
    				count++;
    		}
    	}
    	return count;
    }

}