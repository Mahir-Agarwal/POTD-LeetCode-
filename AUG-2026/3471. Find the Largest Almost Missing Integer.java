class Solution {

    // sexy observation first and last elemnt he ho sakta hai answer because ye do number he ek bar aynge kisibhi subarray me , baaki har bar he multiple subarray me aynge 

    public int largestInteger(int[] nums, int k) {

        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        if (k == 1) {
            int max = -1;

            for (int i = 0; i < nums.length; i++) {

                if (map.get(nums[i]) == 1)
                    max = Math.max(max, nums[i]);
            }

            return max;

        }
        if (k == n) {
            int max = -1;

            for (int x : nums) {
                max = Math.max(max, x);
            }

            return max;
        }
        // int ans = -1;
        // if(map.get(nums[0]) ==1  ) ans =  Math.max(nums[0],ans);
        // if( map.get(nums[n-1]) == 1 ) ans =  Math.max(nums[n-1],ans);;

        int ans = -1;

        if (map.get(nums[0]) == 1)
            ans = Math.max(ans, nums[0]);

        if (map.get(nums[n - 1]) == 1)
            ans = Math.max(ans, nums[n - 1]);

        return ans;

    }
}
tc -> O(n)