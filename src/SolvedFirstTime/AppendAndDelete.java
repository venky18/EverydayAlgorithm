package SolvedFirstTime;

import java.util.Scanner;

/**
 * A easy problem with many edge cases
 * https://www.hackerrank.com/contests/w25/challenges/append-and-delete
 */
public class AppendAndDelete {
    public static void main(String ...args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine(), n = scn.nextLine();
        int k = scn.nextInt();
        solve(s, n, k);
    }

    public static void solve(String s, String n, int k) {
        // find the first diff char
        int diff = -1;
        for (int i = 0; i < s.length() + 1; i++) {
            if ((i == s.length() && i < n.length()) || (i >= n.length() && i < s.length())) {
                diff = i;
                break;
            } else if (i < n.length() && s.charAt(i) != n.charAt(i)) {
                diff = i;
                break;
            }
        }
        // decide based on position of diff char
        if (diff == -1) { // same strings
            if (k >= s.length() * 2 || k % 2 == 0) {
                System.out.println("Yes");
                return;
            }
        } else { // different
            int max = Math.max(s.length(), n.length());
            int min = Math.min(s.length(), n.length());
            int minops = (max - diff) + (min - diff); // minimum # of operations
            if ((k >= minops && (k - minops) % 2 == 0) || k >= s.length() + n.length()) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
