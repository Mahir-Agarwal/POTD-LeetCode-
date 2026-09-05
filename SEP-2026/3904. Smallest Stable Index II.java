class Solution {
    public int firstStableIndex(int[] nums, int k) {
         int n = nums.length;
        int i = 1 ;
        int j = n-2 ;

        int max[] = new int [n];
        max[0] = nums[0];
        int min[] = new int [n];
        min[n-1] = nums[n-1];

        for(  ; i < n && j >=0 ; i++,j--){

            max[i] = Math.max(nums[i], max[i-1]);
            min[j] = Math.min(nums[j], min[j+1]);
        }

        // int res = -1 ;
        for(i = 0 ; i < n ; i++){

            int curr = max[i] - min[i] ;
            if(curr <=k) return i;
        }

        return -1;
    }
}