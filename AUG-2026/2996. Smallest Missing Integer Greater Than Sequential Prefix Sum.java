class Solution {
    public int missingInteger(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
    
        int curr = nums[0]; 
    
        for(int i = 1 ; i < nums.length ; i++ ){

            if(nums[i] == (nums[i-1]+1)){
                curr += nums[i];
            }
            else {
                break ; 
            }
            
        }

        for(int x : nums) set.add(x);
        
        int min = curr ;

        while(true){
            if(!set.contains(min)) return min ;
            min++;
        }

        
        
    }
}