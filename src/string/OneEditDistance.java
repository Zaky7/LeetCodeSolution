package string;

public class OneEditDistance {

    public boolean isOneEditDistance(String s1, String s2) {
        int s1_len = s1.length();
        int s2_len = s2.length();

        // Two string differ in length more than 1 character
        if(Math.abs(s1_len - s2_len) > 1) {
            return false;
        }

        if(s1_len == s2_len) {
            return onEditReplaceDistance(s1, s2);
        } else if(s1_len < s2_len) {
            return oneEditDistanceInsert(s1, s2);
        } else {
            return oneEditDistanceInsert(s2, s1);
        }
    }

    public boolean onEditReplaceDistance(String s1, String s2) {
        boolean isFound = false;

        int n = s1.length();


        for(int i=0; i<n; i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(isFound) {
                    return false;
                }

                isFound = true;
            }
        }

        return isFound;
    }

    public boolean oneEditDistanceInsert(String smallStr, String largerStr) {
        boolean isFound = false;
        int index1 = 0;
        int index2 = 0;

        while(index1 < smallStr.length() && index2 < largerStr.length()) {
            if (smallStr.charAt(index1) != largerStr.charAt(index2)) {
                if(isFound) {
                    return false;
                }
                isFound = true;
            } else {
                index1++;
            }
            index2++;
        }

        return true;
    }

    public static void main(String[] args) {
            String[] s1 = {"Pal",  "mat",  "bro",      "bugg",  "",  "ab", "blab", "pick", "zampr"};
            String[] s2 = {"xale", "pat",  "bromance", "debug", "",   "cab", "bab", "pickr", "ampr"};
            int testcases = s1.length > s2.length ? s1.length: s2.length;
            OneEditDistance oed = new OneEditDistance();

            for (int i=0; i<testcases; i++) {
                boolean isOneDistanceAway = oed.isOneEditDistance(s1[i], s2[i]);
                System.out.println("String s1: " + s1[i] + " String s2: " + s2[i] + " are one character away: " + isOneDistanceAway);
            }
    }
}
