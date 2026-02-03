class Solution {
    public boolean isTrionic(int[] nums) {

        if(nums[1]<nums[0]) return false;
        
        boolean inc1 = false;
        boolean dec = false;
        boolean inc2 = false;
        int i =0;
        while(i<nums.length-1){ // inc
            if(nums[i+1]>nums[i]) inc1 =true;
            else break;
            i++;
        }
        while(i<nums.length-1){ // inc
            if(nums[i+1]<nums[i]) dec =true;
            else break;
            i++;
        }
        while(i<nums.length-1){ // inc
            if(nums[i+1]>nums[i]) inc2 =true;
            else break;
            i++;
        }

        return  i>=nums.length-1 && (inc1 && inc2 && dec) ;

    }
}

//[8,9,4,6,1]
//[ < > < >  ]


//T.C - >  O(N)
//S.C - >  O(1)