import java.util.*;

class Sortings2D {

    public static void main(String[] args) {
        int[][] pairs = { {10,16},{2,8},{1,6},{7,12}, {2,4} };

        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] == b[0])
                    return Integer.compare(a[1], b[1]);
                else
                    return Integer.compare(a[0], b[0]);
            }
        });

        for(int i = 0; i < pairs.length; i++) {
            System.out.println("[" + pairs[i][0] + ", " + pairs[i][1] + "]");
        }
    }
}
