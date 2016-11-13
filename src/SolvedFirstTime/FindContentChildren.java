package SolvedFirstTime;

import java.util.Arrays;

/**
 * Leetcode contest problem
 * https://leetcode.com/contest/smarking-algorithm-contest-4/problems/assign-cookies/
 *
 * Greedy algorithm that can be prove by an observation that "if the smallest cookie can not satisfy
 * the least greedy child, the cookie is thrown away". We build our greedy recursive relation with it
 */
public class FindContentChildren {
  public static void main(String[] args) {
    System.out.println(solve(new int[]{1, 2}, new int[]{1, 1, 1}));
  }

  public static int solve(int[] g, int[] s) {
    if (g == null || s == null || g.length == 0 || s.length == 0) {
      return 0;
    }
    Arrays.sort(g);
    Arrays.sort(s);
    int j = 0;
    int count = 0;
    for (int value : s) {
      if (value >= g[j]) {
        count++;
        j++;
      }
      if (j == g.length) {
        break;
      }
    }
    return count;
  }
}
