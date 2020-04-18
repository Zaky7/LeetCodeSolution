package util;

public class Util {
     public static void printArr(int[] arr) {
         int n = arr.length;
         for(int i=0; i<n; i++) {
             System.out.print(arr[i] + " ");
         }
         System.out.println();
     }

     public static void compareArr(int[] arr1, int[] arr2) {
         int len1 = arr1.length;
         int len2 = arr2.length;

         if(len1 != len2) {
             throw new UnsupportedOperationException("Length are not equal");
         } else if(len1 == 0) {
             throw new UnsupportedOperationException("One of the Array is Empty");
         } else {
             for(int i=0; i<len1; i++) {
                 if(arr1[i] != arr2[i]) {
                     throw new UnsupportedOperationException("Expected " + arr1[i] + " to equal to " + arr2[i]);
                 }
             }
             System.out.println("Both arr are equal");
         }
     }
}