package string;

class StringUnique {

  private boolean isLowerAlpha(char ch) {
    return ch >= 97 && ch <= 122;
  }

  private boolean isUpperAlpha(char ch) {
    return ch >= 65 && ch <= 90;
  }

  public boolean isUnique(String str) {
    int[] lowerAlphaArr = new int[26];
    int[] upperAlphaArr = new int[26];
    boolean isUnique = true;

    // Check if XOR is zero then it is not a unique alphabet String
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (isLowerAlpha(ch)) {
        int index = (int) ch - 97;

        if (lowerAlphaArr[index] != 0) {
          // System.out.println("Character: " + ch + " is present");
          isUnique = false;
          break;
        } else {
          // System.out.println("Character: " + ch + " is not present");
          lowerAlphaArr[index] += 1;
        }
      } else if (isUpperAlpha(ch)) {
        int index = (int) ch - 65;

        if (upperAlphaArr[index] != 0) {
          // System.out.println("Character: " + ch + " is present");
          isUnique = false;
          break;
        } else {
          // System.out.println("Character: " + ch + " is not present");
          upperAlphaArr[index] += 1;
        }
      }
    }

    return isUnique;
  }

  public static void main(String[] args) {
    StringUnique s = new StringUnique();
    String input = "adsbac";
    if (s.isUnique(input)) {
      System.out.print("Yes");
    } else {
      System.out.print("No");
    }
  }
}
