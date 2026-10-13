class Solution {
    public long maxAlternatingSum(int[] arr) {
        
        long max = 0 ;
        int nums[] = new int [arr.length];
        for(int i = 0; i < arr.length ;i++) nums[i] = Math.abs(arr[i]);

        Arrays.sort(nums);

        int s =0 ;
        int e = nums.length-1 ; 

        while( s < e ){

            long curr = (long) nums[e] * nums[e]
          - (long) nums[s] * nums[s];

            max += curr ;
            s++;
            e--;
        }

        return  nums.length %2 == 0 ? max :  max + (long) nums[s] * nums[s];

        
    }
}