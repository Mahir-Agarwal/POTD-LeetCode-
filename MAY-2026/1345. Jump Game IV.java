class Solution {
    public int minJumps(int[] nums) {
        
        HashMap<Integer,List<Integer>> map = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(nums[i]) == false){
                map.put(nums[i], new ArrayList<>());
                map.get(nums[i]).add(i);
            } 
            else map.get(nums[i]).add(i);
        }

        LinkedList<int[]> q = new LinkedList<>();
        boolean visited[] = new boolean [nums.length+1];
        q.add(new int []{ 0, 0 });
        visited[0] = true ;
        

        while(!q.isEmpty()){
            int curr[] = q.poll();
            int i = curr[0];
            int dist = curr[1];
            visited[i] = true;
            if(i == nums.length-1) return dist;
            //1 st case
            if( (i+1) < nums.length && !visited[i+1]) q.add(new int [] { i+1 , dist+1});
            // 2nd case 
            if( (i-1) >=0  && !visited[i-1]) q.add(new int [] { i-1 , dist+1});

            // 3rd case

            for(int k : map.get(nums[i])){
                if(!visited[k] ) q.add(new int [] { k , dist+1});
            }
            
            map.get(nums[i]).clear();
        }

        return -1 ; 
    }
}