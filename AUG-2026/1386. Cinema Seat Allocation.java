public class Solution {
    public int maxNumberOfFamilies(int n, int[][] grid) {
        
        HashMap<Integer, int[]> map = new HashMap<>();

        for(int[] x : grid) {
            map.putIfAbsent(x[0], new int[12]);
            map.get(x[0])[x[1]] = 1;
        }

        int ans = (n- map.size() )*2; //. we cannot assign ans = 0 , because kuch row hongi jisme ek bhi seat reserve nhi hogi toh usme ek grp 2 baar bthe sakta hai toh ans = (n- map.size)*2
        for(int[] curr : map.values()){

            // three condition like ya toh 2,3,4,5 and 6,7,8,9 koi nhi hoga ya
            boolean left = (curr[2]== 0 && curr[3]== 0 && curr[4]== 0 &&
                            curr[5]== 0 );
            boolean right = (curr[6]== 0 && curr[7]== 0 && curr[8]== 0 &&
                            curr[9]== 0 );
            boolean  mid = (curr[4]== 0 && curr[5]== 0 && curr[6]== 0 &&
                            curr[7]== 0 );

            if(left && right ) ans+=2;
            else if (left || right || mid ) ans+=1;
        }

        return ans ;
    }
}

// giving tle because har row ke liye memory allocate ho rahi toh , toh we gonna use map  {
    
}
