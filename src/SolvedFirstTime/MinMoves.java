package SolvedFirstTime;

/**
 * Leetcode contest problem, pretty easy but the idea is intriguing
 * The most important thing to know is that "increment n - 1 element" has the same effect as
 * decrement 1 element, in terms of making all number the same
 * https://leetcode.com/contest/12/problems/minimum-moves-to-equal-array-elements/
 */
public class MinMoves {
  public static void main(String[] args) {
    System.out.println(solve(new int[]{1,2,3}));
    System.out.println(solve(new int[]{-1,0,1}));

  }

  public static int solve(int[] nums) {
    int min = Integer.MAX_VALUE;
    for (int i : nums) {
      min = Math.min(i, min);
    }

    int count = 0;
    for (int i : nums) {
      count += i - min;
    }
    return count;
  }
}
