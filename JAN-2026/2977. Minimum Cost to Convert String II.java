class Solution {

    class Node{
        Node[] next =  new Node[26];
        int id =-1; 
    }
    public int uniqueId=0;
    public Node root =new Node();
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {

        //build Tries and map String to id

        for(String s :original) insert(s);
        for(String s :changed) insert(s);
        
        int n = uniqueId;
        long dist[][] = new long [n][n];
        for(int i = 0 ;i<n ;i++){
            for(int j = 0 ;j<n;j++){
                if(i==j) dist[i][j]=0;
                else dist[i][j] = Long.MAX_VALUE;
            }
        }

        for(int i =0 ; i< cost.length ; i++){
            int  u = findId(original[i]);
            int  v = findId(changed[i]);
            dist[u][v] =Math.min(dist[u][v],(long)cost[i]);
        }

        for(int via= 0 ; via <n; via++){
            for(int i = 0 ;i<n ;i++){
                for(int j = 0 ; j<n;j++){
                    if(dist[i][via]==Long.MAX_VALUE || dist[via][j] ==Long.MAX_VALUE) continue;
                    dist[i][j]  = Math.min(dist[i][j], dist[i][via]+dist[via][j]);
                }
            }
        }

        long dp[] = new long[source.length()+1];// dp[x] = minimum cost to convert 
                                                // source[0 ... x-1]  →  target[0 ... x-1]
        Arrays.fill(dp,Long.MAX_VALUE);
        dp[0]=0;
        // dp logic
        

        // main logic  
        for(int i = 1; i <=source.length() ; i++){
            
            if(dp[i-1]==Long.MAX_VALUE) continue; 

            if(source.charAt(i-1)==target.charAt(i-1)) {
                dp[i] = Math.min(dp[i],dp[i-1]); 
            }
            Node p1 = root;
            Node p2 = root;

            for(int j =i-1 ; j<source.length();j++){
                
                int s =  source.charAt(j)-'a';
                int t =  target.charAt(j)-'a';

                
                p1=p1.next[s];
                p2=p2.next[t];
                if(p1 == null || p2 == null) break;

                if(p1.id!=-1 && p2.id!=-1 && dist[p1.id][p2.id]!=Long.MAX_VALUE){//source[i-1 ... j] → target[i-1 ... j] is possible
                     dp[j+1] = Math.min(dp[j+1],dp[i-1]+dist[p1.id][p2.id]);
                }

                // why dp[j+1]  why j+1?
                // substring end at j , uska length toh j+1 hoga na ,coz 0 index based hai ez

                // why dp[j+1] = Math.min(dp[j+1],dp[i-1]+dist[p1.id][p2.id]) ?
                // we alredy convert souce[0...i-2] now souce[i-1...j] karna so total cost become souce[i-1...j]+cost_of_substring 
            }
        }

        return dp[source.length()] ==Long.MAX_VALUE ?-1 : dp[source.length()];
    }

    public void insert(String s){
        Node curr = root; 
        for(int i =0 ;i<s.length();i++){
            int ch = s.charAt(i)-'a';
            if(curr.next[ch]==null){
                curr.next[ch] = new Node();
            }
            curr = curr.next[ch];
        }
        if(curr.id ==-1) curr.id = uniqueId++;
    }
    public int  findId(String s){
        Node curr = root; 
        for(int i =0 ;i<s.length();i++){
            int ch = s.charAt(i)-'a';
            curr = curr.next[ch];
        }
        return curr.id ;
    }


}

