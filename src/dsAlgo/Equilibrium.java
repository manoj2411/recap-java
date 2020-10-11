/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

public class Equilibrium {
    public static void main (String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // int T = scanner.nextInt();
        // for (int i = 0; i < T; i++) {
        //     int N = scanner.nextInt();
        //     int[] a = new int[N];
        //     for (int j = 0; j < N; j++) {
        //         a[j] = scanner.nextInt();
        //     }
        //     System.out.println(equilibrium(a, N));
        // }
        int[] a = {1,1};
        System.out.println(equilibrium(a, a.length));
    }

    static int equilibrium(int[] a, int N) {
        if (N < 2) return 1;

        int[] sumFromRight = new int[N];
        int sum = 0;
        for (int i = N - 1; i >= 0; i--) {
            sum += a[i];
            sumFromRight[i] = sum;
        }
        sum = a[0];

        for (int i = 1; i < N - 1; i++) {
            if (sum == sumFromRight[i + 1]) return i + 1;
            sum += a[i];
        }
        return -1;
    }
}
