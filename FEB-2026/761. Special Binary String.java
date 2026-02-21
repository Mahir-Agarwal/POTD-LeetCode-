// -> "11011000"
//  if we see that above string me special 10 and 1100 hai what if ye string apne ne aur special bana rahi ho choti substring means this is recursion question 
// Approach -> 
class Solution {
    public String makeLargestSpecial(String s) {
        
        List<String> list = new ArrayList<>();

        int j = 0;
        int count =0 ; 

        for(int i =0 ; i < s.length() ; i++){
            char ch = s.charAt(i);

            if(ch =='1'){
                count++;
            }else  count--;

            if(count ==0 ){
                list.add('1'+ 
                makeLargestSpecial(s.substring(j+1,i) )+'0');
                j = i+1;
            }
        }

        Collections.sort(list ,Collections.reverseOrder());


        return String.join("",list);
    }
}

//T.C -> O(nlogn) for sorting and O(n) for traversing the string so overall O(nlogn)
//S.C -> O(n) for storing the list of special binary string and O(n) for recursion stack so overall O(n)