import java.io.*;
import java.util.*;

/**
 * Easy problem
 * The trick is interesting but not very hard to think of
 * https://www.hackerrank.com/challenges/flipping-the-matrix
 */

public class FlippingTheMatrix {
	public static void main(String ...args) {
		Scanner scn = new Scanner(System.in);
		int q = scn.nextInt();
		String[] line;
		for (int m = 0; m < q; m++) { // matrix
			int n = scn.nextInt();
			int[][] rec = new int[2 * n][2 * n];
			for (int i = 0; i < 2 * n; i++) { // row
				for (int j = 0; j < 2 * n; j++) { // col
					rec[i][j] = scn.nextInt();
				}
			}
			int sum = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sum += Math.max(rec[i][j], Math.max(rec[2 * n - i - 1][j], Math.max(rec[i][2 * n - j - 1], rec[2 * n - i - 1][2 * n - j - 1])));
				}
			}
			System.out.println(sum);
		}
	}
}