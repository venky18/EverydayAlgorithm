package SolvedFirstTime;
import java.util.Arrays;

/**
 * Easy problem: find an index such that sum of A[0 -> p-1] = A[p+1 -> n - 1]
 * Just pay attention why doing any add, multiplications or anything makes the input larger
 * that the result might be out of range (note I used long below for the sum)
 */
public class EquilibriumNumber {
    public static void main(String...args) {
        EquilibriumNumber sol = new EquilibriumNumber();
        int[] test = new int[99999];
        Arrays.fill(test, 2147483647);
        System.out.println(sol.solution(new int[]{1,-1,2}));
    }

    public int solution(int[] A) {
        // preprocess: get the sum
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        // get the presum up to i
        long presum = 0;
        for (int i = 0; i < A.length; i++) {
            if (presum == sum - presum - A[i]) { // if presum equals the sum afterwards
                return i;
            }
            presum += A[i];
        }
        return -1;
    }
}
