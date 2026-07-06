
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0])
                return a[0]-b[0];
            return b[1] - a[1];
        });

        int count = 0;
        
        int ele = 0 ;
        for(int x [] : intervals){

            if(ele  < x[1] ) {
                ele = x[1];
                count++;
            }
        }
        

        return  count;
    }
}

//T.C ->  O(n.Logn)
//S.c ->O(1)