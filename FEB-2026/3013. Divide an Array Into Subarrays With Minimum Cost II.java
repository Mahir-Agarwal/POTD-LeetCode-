class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        
            TreeSet<Pair<Integer,Integer>> kmin = new TreeSet<>(
        (a, b) -> {
            if (!a.getKey().equals(b.getKey()))
                return a.getKey() - b.getKey();
            return a.getValue() - b.getValue(); // tie-breaker
        }
    ); // stores k-1 smallest elements of current window

    TreeSet<Pair<Integer,Integer>> remain = new TreeSet<>(
        (a, b) -> {
            if (!a.getKey().equals(b.getKey()))
                return a.getKey() - b.getKey();
            return a.getValue() - b.getValue();
        }
    ); // stores all other elements
        int n = nums.length ;

        long sum = 0; //sum of elements present in kmin 
        int i =1 ;

        // This loop builds the first sliding window ko i-dist pe set kar denge  with vaha tak ka k-1 smallest sum  
        while(i<=dist){ 
            kmin.add(new Pair<>(nums[i],i));
            sum+=nums[i];
            if(kmin.size() >k-1){
                Pair<Integer,Integer> p = kmin.last();
                sum -=p.getKey();
                remain.add(p);
                kmin.remove(p);
            }
            i++;    
        }

        // 0,1....i -> idx
        //slides the window one step at a time
        // maintains k-1 smallest elements in the window 
        //updates the minimum cost
        long res = Long.MAX_VALUE;
        while( i<n ){
             kmin.add(new Pair<>(nums[i],i));
            sum+=nums[i];
            if(kmin.size() >k-1){
                Pair<Integer,Integer> p = kmin.last();
                sum -=p.getKey();
                remain.add(p);
                kmin.remove(p);
            }
            
            res = Math.min(res,  sum);

            // window shift 
            // i-dist wala element will me removed 
            Pair<Integer,Integer> remove = new Pair<>(nums[i-dist],i-dist) ; 
            int idx = i-dist;

            if(kmin.contains(remove)){
                kmin.remove(remove);
                sum -=nums[i-dist];
                if(!remain.isEmpty()){
                    Pair<Integer,Integer> temp = remain.first();
                    sum +=temp.getKey();
                    kmin.add((temp));
                    remain.remove(temp);
                }
            }else{
                remain.remove(remove);
            }
            i++;
        } 

        return res+nums[0];


    }
}

//T.C -> O(N log K)
//S.C -> O(K) 