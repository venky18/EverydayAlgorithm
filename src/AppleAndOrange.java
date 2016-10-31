import java.io.*;
import java.util.*;

/**
 * Trivial
 * https://www.hackerrank.com/challenges/apple-and-orange
 */
public class AppleAndOrange {
	public static void main(String...args) {
		Scanner scn = new Scanner(System.in);
		String[] str = scn.nextLine().split(" ");
		int s = Integer.parseInt(str[0]); // house
		int t = Integer.parseInt(str[1]);
		str = scn.nextLine().split(" ");
		int a = Integer.parseInt(str[0]); // apple tree
		int b = Integer.parseInt(str[1]);
		str = scn.nextLine().split(" ");
		int m = Integer.parseInt(str[0]); // # of apple
		int n = Integer.parseInt(str[1]);
		int oc = 0, ac = 0, p;
		for (int i = 0; i < m; i++) {
			p = a + scn.nextInt();
			if (p >= s && p <= t) {
				ac++;
			}
		}
		for (int i = 0; i < n; i++) {
			p = b + scn.nextInt();
			if (p >= s && p <= t) {
				oc++;
			}
		}
		System.out.println(ac);
		System.out.println(oc);
	}
}