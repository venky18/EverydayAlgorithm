package SolvedFirstTime;
import java.util.Scanner;

/**
 * Pretty tricky problem, need to think thoroughly
 * https://www.hackerrank.com/contests/w25/challenges/baby-step-giant-step
 */
public class BabyStepGiantStep {
    public static void main(String...args) {
        Scanner scn = new Scanner(System.in);
        int q = scn.nextInt();
        for (int i = 0; i < q; i++) {
            int a = scn.nextInt();
            int b = scn.nextInt();
            int d = scn.nextInt();
            System.out.println(solve(a, b, d));
        }
    }

    public static int solve(int a, int b, int d) {
        if (d == 0) {
            return 0;
        }
        if (d < a) {
            return 2;
        }
        if (d == a) {
            return 1;
        }
        if (d < b) {
            return 2;
        }
        if (d == b) {
            return 1;
        }
        if (d > b) {
            return d / b + 1;
        }
        return -1;
    }
}
