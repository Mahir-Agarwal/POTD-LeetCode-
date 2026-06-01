class Solution {
    public int minimumCost(int[] cost) {
        
        if(cost.length == 1) return cost[0];
        Integer costs[] = new Integer[cost.length];
        for(int i =0 ;  i < cost.length; i++) costs[i] = cost[i];

        Arrays.sort(costs , Collections.reverseOrder());

        int res =0 ;

        for(int i = 0 ; i < costs.length; i++ ){
            
            if( i % 3 != 2 ) res += costs[i];
        }

        return res ;
    }
}
//                    0  1. 2. 3. 4  5
// // 6,5,7,9,2,2] -> 9 ,7 ,6 ,5 ,2 ,2 
//                     16 +5 + 2 
                   