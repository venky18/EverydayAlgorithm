package SolvedFirstTime;

public class LicenseKeyReformat {
  public static void main(String[] args) {
    System.out.println(solution("2easdfsdf312312d", 1));
  }

  /**
   * Returns the license key S in the correct format
   * @param S the misformatted license key
   * @param K the maximum length of license key element
   * @return the formated license key string
   */
  public static String solution(String S, int K) {
    S = S.replace("-", "");
    String result = "";
    for (int i = S.length(); i > 0; i -= K) { // i is the end of current element
      int begin = Math.max(i - K, 0);
      String element = S.substring(begin, i).toUpperCase();
      if (i == S.length()) {
        result = element;
      } else {
        result = element + "-" + result;
      }
    }
    return result;
  }
}
