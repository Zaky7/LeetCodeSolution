package recursionOrDp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Solution {

    public static int maximumHousesToBuy(int[] houses, int budget) {
        Arrays.sort(houses);
        int maximumHousesToBuy = 0;

        for(int i=0; i<houses.length; i++) {
            if(budget >= 0) {
                budget -= houses[i];
                maximumHousesToBuy++;
            }
        }
        return maximumHousesToBuy;
    }

    public static void main(String[] args) {
//        int[] houses = {9,3};
//
//        int product = Arrays.stream(houses).reduce((house1, house2) -> house1 * house2).getAsInt();
//        System.out.println(product);
//
//        ArrayList<Integer> result = new ArrayList<>();
//        result.add(9);
//        result.add(3);
//
//        Object[] arr2 = result.toArray();


        int budget = 50;
        
        int[][] arr = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};

        int n = arr.length;

        for (int i = 2; i < n; i++) {
            for (int j = 0; j < (n-i); j++) {
                int index = i + j;
                System.out.print(arr[j][index] + " ");
            }
            System.out.println();
        }
        

//        System.out.println(maximumHousesToBuy(houses, budget));
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int totalTestcase = scanner.nextInt();
//        int testCases = 1;
//
//        while(testCases <= totalTestcase) {
//            int housesLen = scanner.nextInt();
//            int budget = scanner.nextInt();
//            int[] houses = new int[housesLen];
//
//            int index = 0;
//            while(index < housesLen) {
//                houses[index++] = scanner.nextInt();
//            }
//
//            int maximum = maximumHousesToBuy(houses, budget);
//            System.out.println("Case #" + (testCases) + ": " + maximum);
//            testCases++;
//        }
//
//        scanner.close();
//    }
}
