package array;


import java.util.Scanner;

//class Solution {
//    public static String solve(Scanner input) {
//        long  N = input.nextLong();
//        long K = input.nextInt();
//        long S = input.nextInt();
//
//
//        long backTime  = (2 * K + N) - 2*S;
//        long retryTime = (K + N);
//
//        return String.valueOf(Math.min(backTime, retryTime));
//    }
//
//    public static void main(String args[]) {
//        Scanner input = new Scanner(System.in);
//        int caseNum = input.nextInt();
//
//        for(int i=1;i<=caseNum; i++) {
//            System.out.println(String.format("Case #%d: %s",i,solve(input)));
//        }
//    }
//}

class Solution {

    public static boolean isBoring(String[] digits) {
        boolean checkOdd = true;
        for (int i = 0; i < digits.length; i++) {
            String digit = digits[i];
            int val = Integer.parseInt(digit);
            if(checkOdd) {
                // if even found at odd position return false
                if(val % 2 == 0) {
                    return false;
                }

                checkOdd = false;
            } else {
                // if odd found at even position return false;
                if(val % 2 != 0) {
                    return false;
                }
                checkOdd = true;
            }
        }

        return true;
    }

    public static String solve(Scanner input) {
        long Num1 = input.nextLong();
        long Num2 = input.nextLong();
        int boringNum = 0;

        for(long i=Num1; i<=Num2; i++) {
            String[] strArr= String.valueOf(i).split("");
            if(isBoring(strArr)) {
                boringNum++;
            }
        }
        return String.valueOf(boringNum);
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int caseNum = input.nextInt();

        for(int i=1;i<=caseNum; i++) {
            System.out.println(String.format("Case #%d: %s",i,solve(input)));
        }
    }
}