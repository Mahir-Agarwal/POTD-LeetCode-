class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        
        int max= 0 ;
        int n1 = nums1.length;
        int n2 = nums2.length;
        // Approach -1 using binary serach  tc -> O(n1.logn2)
        // for(int i =0 ; i < n ; i ++){
            
        //     max =Math.max(max, bs(nums1[i], i+1 , nums2.length-1 , nums2 ) - i );
            
        // }

        int i = 0;
        int j = 0;
        // app -2 using two pointer tc -> O(Math.max(n1,n2))
        while ( i < n1 && j < n2){

            if(nums1[i] <= nums2[j]){
                max = Math.max( max , j-i);
                j++;
            }else {
                i++;
                j++;
            }
        }

        return max ;
    }

    public int bs(int tar , int s ,int e , int nums[]){

        int res = 0 ;
        
        while(s <= e ){
            int mid=  (s+e)/2;

            if( nums[mid] >= tar){
                res = Math.max(res ,mid) ;
                s = mid+1;
            }
            else e = mid-1;
        }
        return res ;
    }
}
