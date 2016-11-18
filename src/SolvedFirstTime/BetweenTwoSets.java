package SolvedFirstTime;
import java.util.*;
import java.io.*;

/**
 * Trivial but my solution is interesting:
 * I calculate greatest common divisor and least common multiplier
 * https://www.hackerrank.com/contests/w25/challenges/between-two-sets
 */

public class BetweenTwoSets {
	public static void main(String ...args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt(), m = scn.nextInt();
		int lcm = scn.nextInt();
		for (int i = 1; i < n; i++) { // get the lcm
			lcm = lcm(lcm, scn.nextInt());
		}
		int gcd = scn.nextInt();
		for (int j = 1; j < m; j++) {
			gcd = gcd(gcd, scn.nextInt());
		}
		int count = 0;
		for (int i = 1; i <= gcd / lcm; i++) {
			if (gcd % (lcm * i) == 0) {
				count++;
			}
		}
		System.out.println(count);
	}

	public static int lcm(int i, int j) {
		return i * j / gcd(i, j);
	}

	public static int gcd(int i, int j) {
		if (i < j) { // make sure i >= j
			int temp = i;
			i = j;
			j = temp;
		}
		int r = i % j;
		while (r != 0) {
			i = j;
			j = r;
			r = i % j;
		}
		return j;
	}


}