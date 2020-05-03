package tree.maxwidth;

public class Solution {

  private boolean isAlpha(char ch) {
    int code = ch;
    return code >= 97 && code <= 122;
  }

  private String evaluateString(String str) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0, n = str.length(); i < n; i++) {
      char ch = str.charAt(i);
      if (isAlpha(ch)) {
        sb.append(ch);
      } else if (ch == '#') {
        if (sb.length() > 0) {
          // delete the last element if character is # and builder is not empty
          sb.deleteCharAt(sb.length() - 1);
        }
      } else {
        throw new UnsupportedOperationException();
      }
    }
    return sb.toString();
  }

  private boolean wrapper(String str) {
    try {
      String result = evaluateString(str);
      System.out.println(result);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.wrapper("ab#$"));
  }
}
