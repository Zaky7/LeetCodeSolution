package array;

public class SearchInSortedArray {

    public int search(int[] nums, int target) {
        return  binarySearchUtil(nums, 0, nums.length - 1, target);
    }

    private int binarySearchUtil(int[] arr, int start, int end, int ele) {
        if(start <= end) {
            int mid = (start + end) / 2;

            if(ele == arr[mid]) {
                return mid;
            } else if(arr[start] <= arr[mid]) {
                if(ele >= arr[start] && ele <= arr[mid]) {
                    // occur in left
                    return binarySearchUtil(arr, start, mid-1, ele);
                } else {
                    // occur in right
                    return binarySearchUtil(arr,mid+1,end, ele);
                }
            } else {
                if(ele >= arr[mid] && ele <= arr[end]) {
                    // occur in right
                    return binarySearchUtil(arr, mid+1, end, ele);
                } else {
                    // occur in left
                    return binarySearchUtil(arr, start, mid-1, ele);
                }
            }
        } else {
            return -1;
        }
    }


    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int target = 0;

        int foundIndex = new SearchInSortedArray().search(arr, target);
        System.out.println("Element found at Index: " + foundIndex);
    }
}   