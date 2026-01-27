class Solution {
    public int minCost(int n, int[][] edges) {
      
       HashMap<Integer,List<int[]>> map = new HashMap<>();

       for(int i[] :edges ){
        int u = i[0];
        int v = i[1];
        int wt = i[2];
        map.putIfAbsent(u, new ArrayList<>());
        map.putIfAbsent(v, new ArrayList<>());
        

        map.get(u).add(new int []{v,wt});
        map.get(v).add(new int []{u,wt*2});
       }

       int res[] = new int [n];
       Arrays.fill(res,Integer.MAX_VALUE);
       PriorityQueue<int []> q=  new PriorityQueue<>((a,b) -> a[1]-b[1] );

       q.add(new int []{0,0}); //v,wt 

       while(!q.isEmpty()){
         
         int [] curr =  q.poll();
         int u = curr[0];
         int wt = curr[1];
        
        if(map.get(u)==null) continue ;
        for(int i[] : map.get(u)){
            int v =i[0];
            int w = i[1];

            if(wt+w <res[v]){
                res[v] = wt+w;
                q.offer(new int[]{v,res[v]});
            }
        }

       }

        return res[n-1]==Integer.MAX_VALUE ? -1 : res[n-1];    

    }
}

//T.C -> O(E log V)
//S.C -> O(E + V)