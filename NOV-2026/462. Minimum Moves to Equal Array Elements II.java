class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int res = 0 ;
        int ele = nums[nums.length/2];

        for(int i = 0 ; i < nums.length ; i++){

            res += Math.abs(ele-nums[i]);
        }

        return res;
    }
}