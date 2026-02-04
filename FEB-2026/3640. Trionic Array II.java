// what im thinking ill take a flag that represent which phase is currently going on like inc or dec or inc  1,2,3 and coz of choices we can use dp 

class Solution {
    long NEG = -100000000000000L; // why this ?
    // max |nums[i]| × n
    // if : |nums[i]| ≤ 10^9
    //      n ≤ 10^5
    //      Max sum ≈ 10^14
    // so : choosing NEG = -1e15 is perfect and safe
    
    public long dp [][];
    public long maxSumTrionic(int[] nums) {
        dp = new long[nums.length][4];
        for(long i []: dp){
            Arrays.fill(i,-1);
        }
        return solve(0,0,nums);

    }

    public long solve(int i , int flag , int []nums){
        
        if( i == nums.length ) return flag ==3 ? 0 : NEG;
        if(dp[i][flag]!=-1) return dp[i][flag];
        long take =NEG;
        long nottake=NEG;
        if(flag ==0) nottake = solve(i+1,0,nums);
        if(flag ==3) take = nums[i];

    if(i+1 <nums.length){
        if(flag ==0 && nums[i+1]>nums[i] ){
            
            take = Math.max(take , nums[i]+ solve(i+1,1,nums));
            
        }else if (flag ==1){
            if(nums[i+1]>nums[i]){
                take = Math.max(take , nums[i]+ solve(i+1,1,nums));
            }else if(nums[i+1]<nums[i]){
                take  =Math.max(take , nums[i]+solve(i+1,2,nums));
            }
        }
        else if(flag ==2 ){
            if(nums[i+1]>nums[i]){
                take = Math.max(take , nums[i]+ solve(i+1,3,nums));
            }else if(nums[i+1]<nums[i]){
                take  =Math.max(take , nums[i]+solve(i+1,2,nums));
            }
        }else if (flag ==3  && nums[i+1]>nums[i]){
            take  = Math.max(take , nums[i]+solve(i+1,3,nums));
        }

       
    }

    return dp[i][flag] =Math.max(take ,nottake);

    }
}

//T.C -> O(N)
//S.C -> O(N)