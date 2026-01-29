class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        
        int n = original.length;
        // HashMap<Character, Map<Character, Integer>> map = new HashMap<>();
        // HashMap<String, Integer> already = new HashMap<>();

        // for (int i = 0; i < n; i++) {

        //     char u = original[i];
        //     char v = changed[i];
        //     int wt = cost[i];

        //     String key = u + "->" + v;

        //     if (already.containsKey(key)) {
        //         int cw = already.get(key);
        //         wt = Math.min(cw, wt);
        //     }

        //     map.putIfAbsent(u, new HashMap<>());
        //     map.get(u).put(v, wt);

        //     already.put(key, wt);
        // }
        int N = 26;
        int grid[][]  = new int[N][N];

        for(int i =0 ; i <N ; i++){
            for(int j = 0 ; j<N ;j++){
                if(i==j) grid[i][j] = 0;
                else grid[i][j] = Integer.MAX_VALUE;
            }
        }

        // for(char u : map.keySet()){
        //     for(char v : map.get(u).keySet()){
        //         int wt = map.get(u).get(v);
        //         grid[u-'a'][v-'a'] = wt;
        //     }
        // }

        for(int i = 0; i <cost.length ; i++){
            int u =  original[i]-'a';
            int  v =  changed[i]-'a';
            grid[u][v] =Math.min(grid[u][v],cost[i]);
        }
        for(int k = 0 ; k< N ; k++){//via
            for(int i = 0 ; i<N; i++){//a
                for(int j =0 ; j<N;j++){//b

                    if(grid[i][k] == Integer.MAX_VALUE || grid[k][j] == Integer.MAX_VALUE) continue ;
                    grid[i][j] = Math.min(grid[i][j] , grid[i][k]+grid[k][j]);
                }
            }
        }
        // main logic 
        long minCost = 0;

        for(int i = 0 ; i<source.length(); i++){

            if(source.charAt(i) == target.charAt(i) ) continue ;

            if(grid[source.charAt(i)-'a'][target.charAt(i)-'a'] >=Integer.MAX_VALUE) return -1;

            minCost += grid[source.charAt(i)-'a'][target.charAt(i)-'a'];

        } 

        return minCost==Integer.MAX_VALUE ? -1  : minCost;
    }
}

//T.C -> O(N^3 + M) , N = 26 , M = length of source string
//S.C -> O(N^2) for grid