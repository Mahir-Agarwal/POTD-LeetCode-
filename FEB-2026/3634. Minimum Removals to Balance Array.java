class Solution {
    public int minRemoval(int[] nums, int k) {
        
        Arrays.sort(nums);
    
        int i = 0;
        int maxLen =0;
        // i represent the smallest ele in array 
        // and j we are scanning array as maxEle
       for(int j =0 ;j <nums.length ;j++){

        if( i<=j && (long) nums[j] > (long)nums[i]*k ){
           i++;
        }
       
       }
        
        return i; // give the minimum no of removals needed 
    }
}

//T.C -> O(n.logn)
//S.C -> O(1)