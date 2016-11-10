package SolvedFirstTime;

public class LargestSubtreeInRange {
  public static void main(String[] args) {
    // did not write test code
  }

  private static class Tree {
    public int x;
    public Tree l;
    public Tree r;
  }

  /**
   * Wrap return results of recursion
   * contained indicates whether the tree is totally contained in the interval
   * size indicates the size of the biggest subtree
   */
  private static class Wrapper {
    public boolean contained;
    public int size;
    public Wrapper(boolean contained, int size) {
      this.contained = contained;
      this.size = size;
    }
    public Wrapper() {
      this.contained = false;
      this.size = 0;
    }
  }

  /**
   * returns the size of the largest subtree in [A, B], 0 if not exist
   * @param A the left bound
   * @param B the right bound
   * @param T the root of the tree
   * @return the size of the largest subtree in [A, B], 0 if not exist
   */
  public static int solution(int A, int B, Tree T) {
    return solutionHelper(A, B, T).size;
  }

  /**
   * Resursion helper for solution. Returns the return as wrapper.
   * Indicates whether the subtree T is fully contained in the range [A, B] or not
   * @param A the left bound
   * @param B the right bound
   * @param T the root of the tree
   * @return A Wrapper that indicates the size of the largest subtree in the range,
   * and whether the subtree is totally contained in the range
   */
  private static Wrapper solutionHelper(int A, int B, Tree T) {
    if (T == null) {
      return new Wrapper(true, 0);
    }

    Wrapper left = new Wrapper();
    Wrapper right = new Wrapper();
    Wrapper result = new Wrapper(false, 0);
    if (T.x < A) {
      right = solutionHelper(A, B, T.r);
      result.size = right.size;
    } else if (T.x > B) {
      left = solutionHelper(A, B, T.l);
      result.size = left.size;
    } else {
      right = solutionHelper(A, B, T.r);
      left = solutionHelper(A, B, T.l);
      if (left.contained && right.contained) {
        result.size = 1;
        result.contained = true;
        result.size += left.size + right.size;
      } else {
        result.size = Math.max(left.size, right.size);
      }
    }
    return result;
  }
}
