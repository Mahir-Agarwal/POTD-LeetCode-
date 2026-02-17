class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        

            List<String> res = new ArrayList<>();

            for(int h= 0;  h<=11 ;h++){
                for(int m=0 ; m<=59 ;m++){
                    
                    int hc = Integer.bitCount(h);
                    int mc = Integer.bitCount(m);
                    if(hc+mc ==  turnedOn){
                        String hour = h +"";
                        String min = (m<10 ? "0":"") +m+"";
                        String curr = hour+":"+min;
                        res.add(curr);
                    }
                } 
            }

            return res;
    }
}
//T.C -> O(1)  S.C -> O(1)