class Solution {
    public int minOperations(int[][] grid, int x) {
        
       int[] arr = Arrays.stream(grid)
                  .flatMapToInt(Arrays::stream)
                  .sorted()
                  .toArray();
        
        int mid = arr[ arr.length / 2 ];

        int answer = 0 ;
        for(int i =0 ; i < arr.length ;i++){

            if ( Math.abs(arr[i] - mid) % x != 0) return -1;

            int res = Math.abs( mid - arr[i]) / x  ;   
            
            answer+=res;

        }

        return answer ;
    }
}

// [2,4,6,8] mid -> 4 x -> 2 
// [1,2,3,5] mid -> 2  x -> 1 
// [1,2,3,4] 