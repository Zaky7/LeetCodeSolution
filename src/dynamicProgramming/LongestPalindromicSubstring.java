package dynamicProgramming;

class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Diagonal element are single length so always pallindrome
        for(int i=0; i<n; i++) {
            dp[i][i] = 1;
        }

        // Next diagonal element
        for(int i = 0; i<n-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = 1;
            }
        }

        for(int j=2; j<n; j++) {
            for(int i=0; i<(n-j); i++) {
                int a = i;
                int b = i + j;
                if(s.charAt(a) == s.charAt(b)) {
                    dp[a][b] = dp[a+1][b-1] == 1 ? 1 : 0;
                }
            }
        }

        StringBuilder sb = new StringBuilder(s.substring(0,1));
        int maxLen = 0;
        for(int j=n-1; j>=0; j--) {
            for(int i=0; i<=j; i++) {
                if(dp[i][j] == 1 && (j - i + 1) > sb.length()) {
                    sb = new StringBuilder(s.substring(i, j + 1));
                }
            }
        }

        return sb.toString();
    }

    private void print(int[][] arr) {
        int n = arr.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


    /*
        T(n): O(n^2)
        S(n): O(1)
     */
    public String longestPalindromeUsingCenterTh(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;

        for(int i=0; i<n; i++) {
            int oddPalindromeLen = palindromeAroundIndex(s, i, i);
            int evenPalindromeLen = palindromeAroundIndex(s, i, i+1);

            int len = Math.max(evenPalindromeLen, oddPalindromeLen);

            if(len > (end - start)) {
                start = i - (len - 1) / 2;
                end  = i + (len / 2);
            }
        }


        return s.substring(start, end + 1);
    }

    private int palindromeAroundIndex(String s, int LEFT, int RIGHT) {
        int left = LEFT;
        int right = RIGHT;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public static void main(String[] args) {
        String str = "babad";
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();

        System.out.println(lps.longestPalindrome(str));
        System.out.println(lps.longestPalindromeUsingCenterTh(str));

    }
}