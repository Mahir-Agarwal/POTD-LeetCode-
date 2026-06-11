class Solution {
    public int mod = (int) 1e9 + 7;

    public int assignEdgeWeights(int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int edge[] : edges) {
            int u = edge[0];
            int v = edge[1];

            map.putIfAbsent(u, new ArrayList<>());
            map.putIfAbsent(v, new ArrayList<>());

            map.get(u).add(v);
            map.get(v).add(u);
        }

        int level = -1 ;
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[map.size() + 1];
        visited[1] = true;
        q.add(1);

        while (!q.isEmpty()) {

            int size = q.size();
            level++;

            for (int i = 0; i < size; i++) {

                int u = q.poll();

                if (map.containsKey(u)) {
                    for (int v : map.get(u)) {
                        if (!visited[v]) {
                            visited[v] = true;
                            q.add(v);
                        }
                    }

                }

            }
        }

        int res = 1;
        for (int i = 0; i < level - 1; i++) {
            res = (res * 2) % mod;
        }
        return res;
    }
}