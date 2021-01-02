package dynamicProgramming;

class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int n = s.length();
        int[][] isPalindrome = new int[n][n];
        int palindromes = 0;

        // Single digit word are pallindrome
        for(int i=0; i<n; i++) {
            isPalindrome[i][i] = 1;
            palindromes += isPalindrome[i][i];
        }

        for(int i=0; i<n-1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                isPalindrome[i][i+1] = 1;
                palindromes += isPalindrome[i][i];
            }
        }

        for(int j=2; j<n; j++) {
            for(int i=0; i<(n-j); i++) {
                int a = i;
                int b = i + j;

                if(s.charAt(a) == s.charAt(b)) {
                    isPalindrome[a][b] = isPalindrome[a+1][b-1] == 1 ? 1 : 0;
                    palindromes += isPalindrome[a][b];
                }
            }
        }

        return palindromes;
    }

    public static void main(String[] args) {
        String str = "abc";
        PalindromicSubstrings ps = new PalindromicSubstrings();
        int sub = ps.countSubstrings(str);
        System.out.println(sub);
    }

}