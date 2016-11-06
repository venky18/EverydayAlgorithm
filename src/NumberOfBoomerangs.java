import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode Contest Problem: brutal force stuff
 * https://leetcode.com/contest/12/problems/number-of-boomerangs/
 */
public class NumberOfBoomerangs {
  public static void main(String[] args) {
    System.out.println(solve(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
    System.out.println(solve(new int[][]{{0, 0}, {1, 0}, {2, 0}, {3, 0}}));
    System.out.println(solve(new int[][]{{0, 0}, {1, 0}, {2, 0}, {1, 1}, {1, -1}}));
  }

  public static int solve(int[][] points) {
    double[][] distances = new double[points.length][points.length];
    // calculate the distance between any two points
    for (int i = 0; i < points.length; i++) {
      for (int j = i; j < points.length; j++) {
        distances[i][j] = getDistance(points[i], points[j]);
        distances[j][i] = distances[i][j];
      }
    }

    int count = 0;
    for (int i = 0; i < points.length; i++) { // for each point
      Map<Double, Integer> map = new HashMap<>();
      // count the number points at each distances
      for (int j = 0; j < points.length; j++) {
        if (map.containsKey(distances[i][j])) {
          int c = map.get(distances[i][j]);
          map.put(distances[i][j], c + 1);
        } else {
          map.put(distances[i][j], 1);
        }
      }

      // if there are c points within this distance, we have c * (c - 1) boomerangs
      for (Double d : map.keySet()) {
        int c = map.get(d);
        count += c * (c - 1);
      }
    }
    return count;
  }

  private static double getDistance(int[] p1, int[] p2) {
    return Math.sqrt((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]));
  }
}
