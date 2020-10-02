package string;

public class PalindromePermutation {
  private static final int CHAR_SIZE = 256;

  private int charCodeAt(String s, int pos) {
    int code = s.charAt(pos);
    return code;
  }

  private int toggleValue(int val) {
    return val == 1 ? 0 : 1;
  }

  private String normalizeString(String str) {
    String s = str;
    s = s.replaceAll("\\s", "");
    s = s.toLowerCase();
    return s;
  }

  public boolean canPermutePalindrome(String s) {
    s = normalizeString(s);
    int n = s.length();
    boolean isPalindrome = true;

    // Assuming the characters to be ascii extended
    int[] chars = new int[CHAR_SIZE];
    int half = n / 2;

    // Set the count of first half
    for (int i = 0; i < half; i++) {
      int code = charCodeAt(s, i);
      chars[code] = toggleValue(chars[code]);
    }

    // Unset the count of second half
    for (int i = half; i < n; i++) {
      int code = charCodeAt(s, i);
      chars[charCodeAt(s, i)] = toggleValue(chars[code]);
    }

    int zeroCount = 0;

    // Check all element are zero then palindrome occur
    for (int i = 0; i < 256; i++) {
      // Count other than 0 or 1
      if (chars[i] == 0) {
        continue;
      } else if (chars[i] == 1 || chars[i] == -1) {
        if (zeroCount == 0) {
          zeroCount++;
        } else {
          // More than one -1 or -1 so string is not palindrome
          isPalindrome = false;
          break;
        }
      } else {
        isPalindrome = false;
        break;
      }
    }

    return isPalindrome;
  }

  public static void main(String[] args) {
    String[] inputs = {
      "code",
      "malayalam",
      "a",
      "aabaa",
      "abaa",
      "ab",
      "aa",
      "?##",
      "##!^",
      "Top spot",
      "Red rum, sir, is murder",
      "list of palindrome words",
    };
    PalindromePermutation p = new PalindromePermutation();

    for (String input : inputs) {
      boolean ans = p.canPermutePalindrome(input);
    }
  }
}
