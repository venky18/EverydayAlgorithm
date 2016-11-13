package SolvedFirstTime;

/**
 * Leetcode contest problem
 * https://leetcode.com/contest/smarking-algorithm-contest-4/problems/repeated-substring-pattern/
 *
 * Check all possible divisions
 */
public class RepeatedSubstringPattern {
  public static void main(String[] args) {
    System.out.println(solve("abcabcab"));

  }

  public static boolean solve(String str) {
    int l = str.length();
    for (int i = 1; i <= l / 2; i++) {
      if (l % i == 0) {
        String sub = str.substring(0, i);
        int j;
        for (j = 1; j < l / i; j++) {
          int start = j * i;
          int end = j * i + i;
          String s = str.substring(start, end);
          if (!sub.equals(s)) {
            break;
          }
        }
        if (j == l / i) {
          return true;
        }
      }
    }
    return false;
  }
}
