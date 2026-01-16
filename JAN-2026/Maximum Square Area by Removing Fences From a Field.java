class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        

        List<Integer> h = new ArrayList<>();
        List<Integer> v = new ArrayList<>();

        for(int i : hFences){
            h.add(i);
        }
        for(int i : vFences){
            v.add(i);
        }

        h.add(1);
        h.add(m);
        v.add(1);
        v.add(n);

        Set<Integer> set =  new HashSet<>();
        for(int i =0 ;i <h.size(); i++){
            for(int j =i+1; j<h.size() ;j++){
                set.add(Math.abs(h.get(j)-h.get(i)));
            }
        }
        long max = 0 ;
        for(int i =0 ;i <v.size(); i++){
            for(int j =i+1 ; j<v.size() ;j++){
                int curr =Math.abs(v.get(j)-v.get(i));;   
                if(set.contains(curr)) max = Math.max(curr,max);

            }
        }
        int mod = (int)1e9+7;
        return max==0 ? -1 :(int) ((max*max)%mod); 
    }
}