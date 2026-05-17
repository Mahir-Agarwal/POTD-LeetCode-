class Solution {
    public boolean canReach(int[] arr, int start) {
        
        LinkedList<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean [arr.length+1 ];
        q.add(start);

        while (!q.isEmpty()){
        
            int curr = q.poll();
            if(arr[curr] == 0 ) return true;
            visited[curr] = true ;

            if(  (curr+ arr[curr] ) <  (arr.length)  &&  !visited[curr+ arr[curr]] ) q.add( curr+ arr[curr]);
            if(  (curr - arr[curr]) >= 0 && !visited[curr -  arr[curr] ]  ) q.add( curr - arr[curr]);
        }

        return false;
    }
}
//T.C -> O(n)
// S.c - > O(n)