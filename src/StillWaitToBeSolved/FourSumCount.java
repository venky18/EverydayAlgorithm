package StillWaitToBeSolved;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Did not manage to solve for the first time. It gave me TLE.
 */
public class FourSumCount {
  public static void main(String[] args) {
    System.out.println(solve(new int[]{0,-19,-7,-3,-18,-29,-29,-23,4,-31,-3,-25,-10,-15,8,-8,-32,6,10,-14,4,-29,-15,-20,-29,-26,-11,-20,-25,-30,3,-6,-12,9,-10,9,10,4,-28,-18,-4,-16,0,-15,-31,9,-28,2,3,-14,-11,-7,-9,-4,-27,-4,-26,-23,-31,-2,-11,-7,7,-3,-19,-5,-11,-6,10,-26,-30,-5,-4,-6,-22,-21,-29,-14,0,-28,5,-16,5,-21,-30,2,-22,-10,-10,-9,-11,-20,-17,1,-4,-17,-18,-15,-30,-29},
        new int[]{-11,-28,-18,1,-1,-2,-10,-8,-19,-4,-13,-20,-2,-16,9,-3,-20,5,-21,8,-29,-28,-5,-25,-27,-3,-11,-13,-13,6,-30,-24,7,-6,-5,-7,-23,-13,-1,-17,-2,9,-25,-24,5,-18,-15,-6,-16,-20,-26,-32,-27,-15,-29,-3,-20,-1,-32,-21,-1,10,-26,8,-18,7,-3,7,0,-27,-25,-5,-16,-5,-23,-26,-16,-29,10,-26,-28,-5,-22,-29,-12,-2,-27,-32,-4,-30,-13,-2,8,-24,-16,-9,9,-27,-12,9},
    new int[]{-26,5,4,-8,-18,-23,-4,10,7,-22,-21,-26,-26,-13,-15,-31,-24,-13,-8,-31,-18,-23,-8,-1,-1,3,-3,-29,-8,-30,-17,-12,-23,-19,-21,-7,-24,8,-2,-29,-26,-20,6,9,-18,-22,-27,-29,-31,1,-32,-14,-31,-31,-24,-8,-30,-20,7,-29,-30,-19,-15,1,1,-30,-25,-12,-16,-14,9,-13,6,-10,-15,-1,-21,-4,-14,1,-21,-7,-15,-24,-16,9,-25,-18,-26,-26,-27,-5,4,-23,8,2,-14,-30,0,-12},
    new int[]{-5,-15,-26,-25,5,3,1,2,-1,-1,-29,-11,6,-23,-12,-27,1,-18,-10,1,9,-2,-21,-12,-7,2,-8,-26,3,-6,0,7,-22,-9,5,10,-29,-14,-25,-9,-1,-32,1,-14,-27,-29,-30,8,-15,2,3,-11,-19,4,-26,-10,3,2,8,-25,7,1,-19,2,-9,-8,-30,1,-29,2,0,-7,6,1,6,8,1,7,-8,-28,3,4,-30,-2,-10,-1,-11,-3,0,-19,0,4,-3,-29,-15,-13,-7,10,10,9}));
  }

  public static int solve(int[] A, int[] B, int[] C, int[] D) {
    Arrays.sort(C);
    Arrays.sort(D);
    HashMap<Integer, Integer> map = new HashMap<>();
    int maxB = Integer.MIN_VALUE;
    int maxC = Integer.MIN_VALUE;
    int maxD = Integer.MIN_VALUE;

    for (int i = 0; i < A.length; i++) {
      int v = A[i];
      maxB = Math.max(maxB, B[i]);
      maxC = Math.max(maxC, C[i]);
      maxD = Math.max(maxD, D[i]);
      if (map.containsKey(v)) {
        int old = map.get(v);
        map.put(v, old + 1);
      } else {
        map.put(v, 1);
      }
    }
    int count = 0;
    for (int aA : A) {
      if (map.get(aA) != -1) {
        count += threeSum(B, C, D, -aA) * map.get(aA);
        map.put(aA, -1);
      }
    }
    return count;
  }

  public static int threeSum(int[] B, int[] C, int[] D, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int v : B) {
      if (map.containsKey(v)) {
        int old = map.get(v);
        map.put(v, old + 1);
      } else {
        map.put(v, 1);
      }
    }
    int count = 0;
    for (int aB : B) {
      if (map.get(aB) != -1) {
        count += twoSum(C, D, target - aB) * map.get(aB);
        map.put(aB, -1);
      }
    }
    return count;
  }

  public static int twoSum(int[] C, int[] D, int target) {
    HashMap<Integer, Integer> cmap = new HashMap<>();
    HashMap<Integer, Integer> dmap = new HashMap<>();
    for (int i = 0; i < C.length; i++) {
      if (cmap.containsKey(C[i])) {
        int old = cmap.get(C[i]);
        cmap.put(C[i], old + 1);
      } else {
        cmap.put(C[i], 1);
      }
      if (dmap.containsKey(D[i])) {
        int old = dmap.get(D[i]);
        dmap.put(D[i], old + 1);
      } else {
        dmap.put(D[i], 1);
      }
    }
    int c = 0;
    int d = D.length - 1;
    int count = 0;
    while (c < C.length && d >= 0) {
      if (C[c] + D[d] < target) {
        int oldc = C[c];
        while (c < C.length && C[c] == oldc) {
          c++;
        }
      } else if (C[c] + D[d] == target) {
        count += cmap.get(C[c]) * dmap.get(D[d]);
        int oldc = C[c];
        int oldd = D[d];
        while (c < C.length && C[c] == oldc) {
          c++;
        }
        while (d >= 0 && D[d] == oldd) {
          d--;
        }
      } else {
        int oldd = D[d];
        while (d >= 0 && D[d] == oldd) {
          d--;
        }
      }
    }
    return count;
  }
}
