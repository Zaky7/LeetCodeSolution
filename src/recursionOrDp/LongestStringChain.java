package recursionOrDp;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.System.in;
import static java.lang.System.out;

class LongestStringChain {

    public int longestStrChain(String[] words) {
        int n = words.length;
        if(n == 0) {
            return 0;
        }

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });


        out.println(Arrays.toString(words));

        int[] chainLengthArr = new int[n];

        Arrays.fill(chainLengthArr, 1);

        for (int i = 1; i < n; i++) {
            out.println("========> " + i);

            for (int j = 0; j < i; j++) {

                if(isDifferByOne(words[i], words[j]))
                    out.println(words[i] + " " + words[j] + "by " + isDifferByOne(words[i], words[j]) + " and is predecessor: " + isPredecessor(words[i], words[j]));

                if(isDifferByOne(words[i], words[j]) && isPredecessor(words[i], words[j])) {
                    chainLengthArr[i] = Math.max(chainLengthArr[i], 1 + chainLengthArr[j]);
                }
            }
        }

        out.println(Arrays.toString(chainLengthArr));

        return Arrays.stream(chainLengthArr).max().getAsInt();
    }

    private boolean isDifferByOne(String word1, String word2) {
        return Math.abs(word1.length() - word2.length()) == 1;
    }

    private boolean isPredecessor(String word1, String word2) {
        boolean predecessor = true;
        String smaller = word1.length() < word2.length() ? word1 : word2;
        String larger  = word1.length() > word2.length() ? word1 : word2;

        int smallerIndex = 0;
        int largerIndex = 0;
        int missMachedChars = 0;

        while (smallerIndex < smaller.length()) {
            if(larger.charAt(largerIndex) != smaller.charAt(smallerIndex)) {
                missMachedChars+=1;
                largerIndex++;
            } else {
                largerIndex++;
                smallerIndex++;
            }

            if(missMachedChars > 1) {
                predecessor = false;
                break;
            }
        }
        return predecessor;
    }

    public static void main(String[] args) {
        String words[] = {"ksqvsyq","ks","kss","czvh","zczpzvdhx", "zczpzvh","zczpzvhx"};

        LongestStringChain lsc = new LongestStringChain();
        out.println(lsc.longestStrChain(words));
    }
}