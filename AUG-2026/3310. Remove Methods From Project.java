class Solution {
    public Set<Integer> set; 
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        set =new HashSet<>();
        for(int i [] :invocations ){

            int u = i[0];
            int v = i[1];

            map.putIfAbsent(u , new ArrayList<>());

            map.get(u).add(v);
        }

        boolean visited [] = new boolean [n];
        // visited[k] = true ;
        // set.add(k);
        dfs1(k , visited , map);

        ArrayList<Integer> res= new ArrayList<>();

        for(int i [] : invocations){

            int u = i [0];
            int v = i[1];

            if(!set.contains(u) && set.contains(v)){
                ArrayList<Integer> list= new ArrayList<>();
                
                for(int l =0 ; l< n ;l++) list.add(l);

                return list;

            }
        }

        for(int i =0 ; i< n ;i++){
            if(!set.contains(i)) res.add(i);
        } 
        return res ;

    }

    public void dfs1(int u  , boolean visited [] ,HashMap<Integer,List<Integer>> map ){

        visited[u] = true;
        set.add(u);
        if(map.containsKey(u)){

            for(int v : map.get(u)){

                if(!visited[v]) dfs1(v , visited,  map);
            }
        }
    }
    
}
T.c -> O(e+v);
