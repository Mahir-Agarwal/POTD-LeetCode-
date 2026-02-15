class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder res = new StringBuilder();

        int i = a.length()-1;
        int j= b.length()-1 ;
        int carry =0;
        while( i>=0 || j>=0 || carry==1 ){
            

            int sum =carry ;
            
            
            if(i>=0) sum += Integer.parseInt(a.charAt(i)+"");
            if(j>=0) sum += Integer.parseInt(b.charAt(j)+"");
            
            // if sum is 2 means we have to append 1 and send carry 1
            res.append(sum%2);

            carry = sum/2;
            i--;
            j--;
        }

        return res.reverse().toString();
        
    }
}

//T.C -> O(max(n,m))  S.C -> O(max(n,m))