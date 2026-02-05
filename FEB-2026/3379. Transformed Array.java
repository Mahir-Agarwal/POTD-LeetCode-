class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int res[] =  new int[n];

        for(int i =0 ; i< n; i++){
            int ele = nums[i];
            int idx = (((i+ele)%n)+n)%n;
            res[i] = nums[idx];
        }

        return res;
    }
}

//T.C -> O(N)
//S.C -> O(1)