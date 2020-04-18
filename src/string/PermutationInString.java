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


                for(int j = i; j < s1.length() + i; j++) {
                    int c = s2.charAt(j) - 97;
                    // That character not present in s1 so break no need to check after
                    if(tempArr[c] == 0) {
                        containsSubArray = false;
                        break;
                    } else {
                        tempArr[c]--;
                        containsSubArray = true;
                    }
                }


                if(containsSubArray == true ) {
                    for(int k=0; k < 26; k++) {
                        // Remain an unset index
                        if(tempArr[k] > 0) {
                            containsSubArray = false;
                            break;
                        }
                    }

                    if(containsSubArray == true) {
                        return true;
                    }
                }

            }
        }

        return false;
    }

}
