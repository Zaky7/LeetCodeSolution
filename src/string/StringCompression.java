package string;

public class StringCompression {

  public int compress(char[] chars) {
    int charLen = chars.length;
    int[] alphabets = new int[52];
    int distinctAlphaCount = fillAlphabetArr(alphabets, chars);

    System.out.println("Alphabet Arr");
    for (int i = 0; i < alphabets.length; i++) {
      System.out.print(alphabets[i] + " ");
    }
    System.out.println();

    int compressedCharArrLen = 2 * distinctAlphaCount;
    if (compressedCharArrLen <= charLen) {
      genCompressedCharString(alphabets, chars);
    }
    return Math.min((2 * distinctAlphaCount), charLen);
  }

  private int fillAlphabetArr(int[] alphabets, char[] chars) {
    int charLen = chars.length;
    int distinctChars = 0;

    for (int i = 0; i < charLen; i++) {
      int charCode = chars[i];

      // [a-z]
      int arrIndex = -1;
      if (charCode >= 97 && charCode <= 122) {
        arrIndex = charCode - 97;
      } else if (charCode >= 65 && charCode <= 90) {
        arrIndex = (charCode - 65) + 26;
      }

      if (arrIndex != -1) {
        if (alphabets[arrIndex] == 0) {
          distinctChars++;
        }
        alphabets[arrIndex] += 1;
      }
    }
    return distinctChars;
  }

  private void genCompressedCharString(int[] alphabets, char[] chars) {
    int alphaIndex = 0;
    for (int i = 0; i < 52; i++) {
      if (alphabets[i] == 1) {
        chars[alphaIndex] = getCharFromCode(i);
        alphaIndex += 1;
      } else if (alphabets[i] > 1) {
        chars[alphaIndex] = getCharFromCode(i);
        String numStr = Integer.toString(alphabets[i]);
        char[] numChar = numStr.toCharArray();

        for (int j = 0; j < numChar.length; j++) {
          chars[alphaIndex + 1] = numChar[j];
          alphaIndex++;
        }

        alphaIndex += 1;
      }
    }
  }

  private char getCharFromCode(int alphabetIndex) {
    if (alphabetIndex >= 0 && alphabetIndex <= 25) {
      // [a-z] range
      alphabetIndex = alphabetIndex + 97;
    } else {
      // [A-Z] range
      alphabetIndex = (alphabetIndex - 26) + 65;
    }
    return (char) alphabetIndex;
  }

  public static void main(String[] args) {
    //        char[] ch..0ars = {'a', 'A', 'a', 'A', 'b', 'a', 'a', 'c', 'e', 'f', 'e', 'f'};
    char[] chars = {
      'a',
      'b',
      'b',
      'b',
      'b',
      'b',
      'b',
      'b',
      'b',
      'b',
      'b',
      'b',
      'b',
    };
    StringCompression sc = new StringCompression();
    sc.compress(chars);
    for (int i = 0; i < chars.length; i++) {
      System.out.print(chars[i] + " ");
    }
  }
}
