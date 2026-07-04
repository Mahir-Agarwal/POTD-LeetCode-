class Solution {
    public int minScore(int n, int[][] roads) {
        
    

        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int i[] : roads) {
            int u = i[0];
            int v = i[1];
            int wt = i[2];

            map.putIfAbsent(u, new ArrayList<>());
            map.putIfAbsent(v, new ArrayList<>());

            map.get(u).add(new int[] { v, wt });
            map.get(v).add(new int[] { u, wt });

        }
        boolean visited[] = new boolean[n+1];
    
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        int min =Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            int u = q.poll();

            if(map.containsKey(u)){
                for(int i [] : map.get(u) ){

                    int v = i[0];
                    int wt = i[1];
                    min =Math.min(wt, min );
                    if(!visited[v]) {
                        visited[v] =true;
                        q.add(v);
                    }    
                }
            }

        }

        return min ; 
    }
}