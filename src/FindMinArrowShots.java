import java.util.Arrays;

/**
 * Leetcode Contest Problem
 * https://leetcode.com/contest/12/problems/minimum-number-of-arrows-to-burst-balloons/
 * Greedy algorithm, same as interval scheduling
 */
public class FindMinArrowShots {
  public static void main(String[] args) {
    System.out.println(solve(new int[][]{{10,16}, {2,8}, {1,6}, {7,12}}));
  }

  public static int solve(int[][] points) {
    if (points == null || points.length == 0) {
      return 0;
    }
    Arrays.sort(points, (o1, o2) -> o1[1] - o2[1]);
    int[] prev = points[0];
    int count = 1;
    for (int i = 1; i < points.length; i++) {
      if (points[i][0] > prev[1]) {
        count++;
        prev = points[i];
      }
    }
    return count;
  }
}
