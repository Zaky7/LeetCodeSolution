# [3Sum](https://leetcode.com/problems/3sum/)

Given an array nums of **n integers**, are there elements a, b, c in nums such that a + b + c = 0? Find **all unique triplets** in the array which gives the **sum of zero**.

Notice that the solution set must **not** contain **duplicate** triplets.

```js
Example;
Input: nums = [-1, 0, 1, 2, -1, -4];
Output: [
  [-1, -1, 2],
  [-1, 0, 1],
];
```

## Naive Approach 👶

We can run three loops and check for each combination of number see it sums up to zero then we add in the array.

```java

T(n) = O(n^3)

/**
* @param nums
* @return
*/
public List<List<Integer>> threeSumNaive(int[] nums) {
    List<List<Integer>> uniqueTripletPairs = new ArrayList<>();
    int n = nums.length;

    for(int i=0; i<n; i++) {
        for(int j=i+1; j<n; j++) {
            for(int k=j+1; k<n; k++) {
                if(nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    uniqueTripletPairs.add(triplet);
                }
            }
        }
    }

```

## Optimal approach

We we need to find 3 nums whose sum equal to zero. There can be possible cases:-

- All the three numbers are zeros
- One number is negative and other number is positive
- Two numbers are negative and one is positive

Pseducode <br>

<pre>

- Sort the array in the ascending order.
- We first fix the first number as i.
- Take two pointer j = i + 1 and k = arr.length - 1;

- Run a while loop until j < k
  if arr[i] + arr[j] + arr[k] < 0:
    - since i is fixed we need to move j to the right in order to increase the value hence:
     j++

  elif arr[i] + arr[j] + arr[k] > 0:
    - since i is fixed we need to move k to the left in order to decrease the value hence:
      k++
  else
     // They are equal add to the result
     List<Integer> triplet = new ArrayList<>();
     triplet.add(arr[i]);
     triplet.add(arr[j]);
     triplet.add(arr[k]);
     result.add(triplet);

     shrink the window size
     j++;
     k--;

================================================================

Caveat 😯!!
  In order to avoid duplicate we need to have additional check in case array contain duplicate elements

  if(i > 0 && arr[i] == arr[i-1]) {
    continue;
  }

  if( (k < arr.length - 1) && arr[k] == arr[k+1] ) {
    k--;
    continue
  }


=================================================================


</pre>

## Final code

```java

/**
* @param nums
* @return
*/
public List<List<Integer>> threeSum(int[] nums) {
    // Sort the existing arr
    Arrays.sort(nums);
    List<List<Integer>> uniqueTripletPairs = new ArrayList<>();
    int n = nums.length;

    for(int i=0; i<n; i++) {
        int j = i + 1;
        int k = nums.length - 1;

        // Avoid duplicate triplet
        if(i > 0 && nums[i] == nums[i-1]) {
            continue;
        }

        while(j < k) {
            // Avoid duplicate triplet
            if(k < (nums.length - 1) && nums[k] == nums[k+1]) {
                k--;
                continue;
            }

            if(nums[i] + nums[j] + nums[k] < 0) {
                j++;
            } else if(nums[i] + nums[j] + nums[k] > 0) {
                k--;
            } else {
                List<Integer> triplet = new ArrayList<>();
                triplet.add(nums[i]);
                triplet.add(nums[j]);
                triplet.add(nums[k]);
                uniqueTripletPairs.add(triplet);
                j++;
                k--;
            }
        }
    }

    return uniqueTripletPairs;
}
```
