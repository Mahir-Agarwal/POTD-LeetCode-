class Solution {
    public int longestBalanced(String s) {
        
        // when single element is making longest substring
        int max =0;
        int count =1; // s[0]
        char []str = s.toCharArray();

        for(int i =1 ; i < str.length; i++){

            if( str[i] == str[i-1]){
                count++;
            }else{
                max = Math.max(max , count);
                count =1; 
            }
        }
        max = Math.max(max, count);

        // if two char making longest string
      
        max  = Math.max(max, solve(str ,'a','b'));
        max  = Math.max(max, solve(str ,'c','b'));
        max  = Math.max(max, solve(str ,'a','c'));

        // last but no the least agar theeno milke bana rahe ho 

        max =Math.max(max , three(str));
       

        return max ;


    }

        public int three(char s[] ){
            //char s[] =  str.toCharArray();
             
        int a=0;
        int b = 0;
        int c =0 ;

        int max =0;

        HashMap<String,Integer> map = new HashMap<>();
        map.put("0#0",-1);
        for(int i =0 ; i<s.length;i++){
            
            if( s[i] =='a') a++;
            else if( s[i] =='b') b++;
            else c++;

            //if(a == b && b == c) max = Math.max(max , a+b+c);

            int diff1 =a-b;
            int diff2 = a-c;
            String diff = diff1 + "#" + (diff2);

            if(map.containsKey(diff)){
                max= Math.max(max , i-map.get(diff));
            }else{
                map.put(diff, i);
            }

            
            
        }
            return max;
        }
   

    public int solve(char[] s , char ch1 , char ch2){

        int max =0;
        int count1=0;
        int count2 =0;
        //char s[] = str.toCharArray();
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for(int i =0  ; i< s.length; i++){

            if(s[i]!=ch1 && s[i]!=ch2){
                map = new HashMap<>(); // tle isliye aa raha i was doing map.clear , but this tech. by creating new obj is not giving tle
                count1=0;
                count2=0;
                map.put(0,i);
                continue;
            }

            if(s[i]==ch1) count1++;
            if(s[i]==ch2) count2++;
           // if(count1 == count2) max= Math.max(max, count1+count2);


            if(map.containsKey(count1-count2)) {
                max= Math.max(max , i-map.get(count1-count2));
            }else{
                map.put(count1-count2 , i);
            }

           

        }

        return max;
    }












}