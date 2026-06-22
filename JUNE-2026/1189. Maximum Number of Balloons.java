class Solution {
    public int maxNumberOfBalloons(String text) {
        
        int map [] = new int [128];
        
        for(int i = 0  ; i < text.length() ; i++){
            int idx  = text.charAt(i)-'a'; 
            map[idx]++;
        }
    

        return Math.min(map['b'-'a'] ,Math.min(map['a'-'a'] , 
            Math.min(map['l'-'a']/2 , Math.min(map['o'-'a']/2 , map['n'-'a']))
        ));
    }
}