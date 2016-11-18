package SolvedFirstTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode contest problem
 * https://leetcode.com/contest/smarking-algorithm-contest-4/problems/132-pattern/
 *
 * By analyzing the pattern, we notice a fact that if this pattern exists, there is a number ('2')
 * that lies between some rising intervals ('1'->'2') to the left
 */
public class Find132pattern {
  private static class Interval {
    int min;
    int max;
    Interval(int min, int max) {
      this.min = min;
      this.max = max;
    }
  }
  public static void main(String[] args) {
    System.out.println(solve(new int[]{-2, 1, 2, -2, 1, 2}));
  }

  public static boolean solve(int[] nums) {
    if (nums.length < 3) {
      return false;
    }
    List<Interval> intervals = new ArrayList<>();
    int i = 1;
    int min, max;
    while (i < nums.length) {
      min = nums[i - 1];
      while (i < nums.length && nums[i] >= nums[i - 1]) {
        for (Interval in : intervals) {
          if (nums[i] < in.max && nums[i] > in.min) {
            return true;
          }
        }
        i++;
      }
      max = nums[i - 1];
      if (max - min > 1) {
        intervals.add(new Interval(min, max));
      }
      while (i < nums.length && nums[i] <= nums[i - 1]) {
        for (Interval in : intervals) {
          if (nums[i] < in.max && nums[i] > in.min) {
            return true;
          }
        }
        i++;
      }
    }
    return false;
  }
}
