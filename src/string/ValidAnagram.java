package string;

import static java.lang.System.out;

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] alphabets = new int[26];

        // Edge Case
        if(s.length() != t.length()) {
            return false;
        }

        s = s.toLowerCase();
        t = t.toLowerCase();

        // Set the alphabet Array
        for(int i=0; i<s.length(); i++) {
            alphabets[indexInArr(s.charAt(i))] += 1;
        }

        // Unset the alphabet Array
        for(int i=0; i<t.length(); i++) {
            alphabets[indexInArr(t.charAt(i))] -= 1;
        }

        for(int i=0; i<26; i++) {
            if(alphabets[i] != 0) {
                return false;
            }
        }

        return true;
    }

    private int indexInArr(char ch) {
        return (int) ch - 97;
    }

    public static void main(String[] args) {
        String s1 = "afb";
        String s2 = "bfa";

        ValidAnagram va = new ValidAnagram();
        boolean anagram = va.isAnagram(s1, s2);
        out.println(anagram);
    }
}
