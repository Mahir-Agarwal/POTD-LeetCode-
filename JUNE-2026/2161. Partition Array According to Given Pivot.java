class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int n = nums.length;  
        int res[] = new int[n];
    
        int idx =0; 
        for( int i = 0  ;  i < n ; i ++){
            if( nums [i]  <  pivot) res[idx++] = nums[i];
            
        }
        for( int i = 0  ;  i < n ; i ++){
            if( nums [i] == pivot) res[idx++] = nums[i];

        }
        
        for(  int i = 0 ;  i < n ; i ++){
            if( nums [i] >  pivot) res[idx++] = nums[i];

        }

        return res ;
    }
}

// Optimized using two pointers

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int n = nums.length;  
        int res[] = new int[n];

        int left =0 ; 
        int right = n-1; 
        int s =0 ;
        int e = n-1 ; 

        while ( s < n && e >=0 ) { 
           
           if(nums[s] < pivot) res[left++]= nums[s];
           if(nums[e]  > pivot) res[right--]= nums[e];

           s++;
           e--;

        }

        while ( left <= right){
            res[left++] = pivot;
        }
        System.out.println(left);
        System.out.println(right);
        return res ;
    }
}
// [9,10,5,10,14,3,12]
     