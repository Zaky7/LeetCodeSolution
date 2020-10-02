    // Method 1. Brute force approach
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n-1; i++) {
            for(int j = i+1; j<n; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }



        /*
       Method 2. Using a Set
       Time Complexity  T(n): O(n)
       Space Complexity S(n): O(n)
    */
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;

        if(n == 0) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            set.add(nums[i]);
        }

        return n != set.size();
    }


public boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; ++i) {
        if (nums[i] == nums[i + 1]) return true;
    }
    return false;
}

        /*
       Method 2. Using a HashMap
       Time Complexity  T(n): O(n)
       Space Complexity S(n): O(n)
      */
        public boolean containsDuplicate(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> numMap = new HashMap<>();
        for(int i=0; i<n; i++) {
            // Map is empty or value not present insert into the map
            if(numMap.isEmpty() || !numMap.containsKey(nums[i])) {
                numMap.put(nums[i], 1);
            } else {
                // Value present in Map
                return true;
            }
        }

        return false;
    }