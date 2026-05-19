class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        
        // Set<Integer> set = new HashSet<>();

        // for(int i  : nums1 ) set.add(i);

        // for(int i  : nums2) if(set.contains(i)) return i ;

        int i = 0 ;
        int j = 0 ; 
        while( i < nums1.length && j < nums2.length){
            if( nums1[i] == nums2[j]) return nums1[i];
            else if (nums1[i] < nums2[j]) i++;
            else j++;
            
        }

        return -1 ; 
    }
}

//T.C -> O(max of nums1. and nums2 length)