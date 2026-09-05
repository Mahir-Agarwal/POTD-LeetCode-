class Solution {
    public boolean uniformArray(int[] nums) {

        // int even = 0 ;
        // int odd = 0 ;
        // int n = nums.length ;

        // for(int x : nums){

        //     if( (x&1) == 0 )even++;
        //     else odd++;
        // }  

        // if(even == n || odd == n || even > odd || odd > even) return true; 
        
        // // if(even > odd || odd > even) return true ;

        // return false;

        // simple appraoch hai agar 4-1 -> 3 , even-odd -> odd, 4-2 ->2 , even-evne -> even, 5-2-> 3 , odd-even -> odd, so simple we just need to take care of odd , even if one odd is presnet in array it can create our entire array odd , so we need to find odd, but here we need to find min odd bevause as mentioned j(min odd ele idx ) with diff nums[i]-nums[j] >=1 so thats why

        int odd = Integer.MAX_VALUE;

        for(int x : nums){
            if(x % 2 == 1 ) odd =Math.min(odd , x );
        }

        if(odd == Integer.MAX_VALUE) return true ; 

        
        for(int x : nums){

            if(x % 2 == 0  && x <=odd) return false;
        }

        return true;
    }
}

 