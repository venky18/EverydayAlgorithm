package DidnotSolveFirstTime;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Did not manage to solve for the first time. It gave me TLE.
 * It turns out that the most stupid way to do this will work:
 * Save all the two sums between A and B
 * Calculate all two sums between C and D and find its counterpart in the AB sums
 * This is O(n^2)
 * My approach, four sum O(n^3)-> three sum O(n^2)-> two sum (O(n))
 */
public class FourSumCount {
  public static void main(String[] args) {

  }

  public static int solve(int[] A, int[] B, int[] C, int[] D) {
    HashMap<Integer, Integer> sum = new HashMap<>();
    for (int i : A) {
      for (int j : B) {
        if (sum.containsKey(i + j)) {
          int old = sum.get(i + j);
          sum.put(i + j, old + 1);
        } else {
          sum.put(i + j, 1);
        }
      }
    }
    int count = 0;
    for (int i : C) {
      for (int j : D) {
        if (sum.containsKey(-i - j)) {
          count += sum.get(-i - j);
        }
      }
    }
    return count;
  }
}
