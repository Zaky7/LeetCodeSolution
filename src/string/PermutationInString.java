package string;

public class PermutationInString {

  public boolean checkInclusion(String s1, String s2) {
    int[] charArray = new int[26];

    // Set the CharArray with String s1
    for (int i = 0; i < s1.length(); i++) {
      int code = (int) s1.charAt(i) - 97;
      // System.out.print(s1.charAt(i) + " ");
      charArray[code]++;
    }

    for (int i = 0; i < (s2.length() - s1.length() + 1); i++) {
      int code = (int) s2.charAt(i) - 97;

      /*
                if Character at that index is 1 then for i to i + s2.length if it is 1
                then it contains permuation of s1 other wise check for next window
            */
      if (charArray[code] > 0) {
        int[] tempArr = charArray.clone();
        boolean containsSubArray = false;

        for (int j = i; j < s1.length() + i; j++) {
          int c = s2.charAt(j) - 97;
          // That character not present in s1 so break no need to check after
          if (tempArr[c] == 0) {
            containsSubArray = false;
            break;
          } else {
            tempArr[c]--;
            containsSubArray = true;
          }
        }

        if (containsSubArray == true) {
          for (int k = 0; k < 26; k++) {
            // Remain an unset index
            if (tempArr[k] > 0) {
              containsSubArray = false;
              break;
            }
          }

          if (containsSubArray == true) {
            return true;
          }
        }
      }
    }

    return false;
  }

  public boolean checkInclusionSlidingWindow(String s1, String s2) {
    int[] str1Map = new int[26];
    int[] str2Map = new int[26];
    int matched_chars = 0;

    if (s1.length() > s2.length()) {
      return false;
    }

    // Mark Maps
    for (int i = 0; i < s1.length(); i++) {
      str1Map[s1.charAt(i) - 'a']++;
      str2Map[s2.charAt(i) - 'a']++;
    }

    // Find count of matched chars
    for (int i = 0; i < 26; i++) {
      if (str1Map[i] != 0) {
        matched_chars += Math.min(str1Map[i], str2Map[i]);
      }
    }

    //    System.out.println(matched_chars);
    //    System.out.println(s2.substring(0, ( 0+ s1.length())) +  " Matched Chars: " + matched_chars);

    for (int i = 1; i < (s2.length() - s1.length()) + 1; i++) {
      //      String str = s2.substring(i, (i + s1.length()));
      //      System.out.print( str +  " Matched Chars: " + matched_chars + " ");

      int prevCharIndex = s2.charAt(i - 1) - 'a';
      int newCharIndex = s2.charAt(i + s1.length() - 1) - 'a';

      if (matched_chars == s1.length()) {
        break;
      }

      // Check new character present in original string
      if (str1Map[newCharIndex] != 0) {
        // Previous count of the new character in s2 is smaller than s1
        // then increment match_count
        if (str2Map[newCharIndex] < str1Map[newCharIndex]) {
          matched_chars++;
        }
        str2Map[newCharIndex]++;
      }

      // Check old character present in original string
      if (str1Map[prevCharIndex] != 0) {
        // Previous count of the old character in s2 is smaller than or equal to s1
        // then increment match_count
        if (str2Map[prevCharIndex] <= str1Map[prevCharIndex]) {
          matched_chars--;
        }

        str2Map[prevCharIndex]--;
      }
      //      System.out.print("Char:(" + s2.charAt(i-1) + ", " + s2.charAt(i + s1.length() - 1) + ")" + " count: [" + str2Map[prevCharIndex] + " ," + str2Map[newCharIndex] + "] " +" matched-char: " + matched_chars + " actual: " + matchedChars(str, s1) ) ;
      //      System.out.println();

    }

    if (matched_chars == s1.length()) {
      return true;
    }

    return false;
  }

  public int matchedChars(String s1, String s2) {
    int[] arr1 = new int[26];
    int[] arr2 = new int[26];
    int count = 0;

    for (int i = 0; i < s1.length(); i++) {
      arr1[s1.charAt(i) - 'a']++;
    }

    for (int i = 0; i < s2.length(); i++) {
      arr2[s2.charAt(i) - 'a']++;
    }

    for (int i = 0; i < 26; i++) {
      count += Math.min(arr1[i], arr2[i]);
    }
    return count;
  }

  public static void main(String[] args) {
    String str1 = "ab";
    String str2 = "abc";

    PermutationInString ps = new PermutationInString();
    System.out.println(ps.checkInclusionSlidingWindow(str1, str2));
  }
}
