import java.util.Scanner;

/**
 * Created by duotao on 11/2/16.
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
