class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> list = new ArrayList<>();

         solve( 0, 0, n , list , "");

        return list ;
    }

    public void solve(int  left ,int right , int n ,  List<String> list , String str ){

        if(str.length() == n*2  ) list.add(str);

        if(left < n ) solve( left+ 1 , right, n , list , str+ "(");

        if( right < left)  solve( left , right +1 , n , list , str + ")");
    }

    // public void solve(int  left ,int right  , int n , List<String> list , String str ){

    //     if( str.length() == n*2 ){
    //         list.add(str);
    //         return ;
    //     }

    //      // left represent "(" open bracket and right -> ")" close bracket
    //     if( left < n ) { // this condition means ,still have opeining bracket "(" to place 
    //         solve(left+1 , right , n , list , str+"(");
    //     }
    //     if(right < left ){ // now this condition close < open , isye ye samaj aa raha ki agar open jada hai toh unka pair pura karna hoga using close ")"
    //         solve(left,right+1 , n , list , str+")");
    //     }
    // }

    // public void solve(int open ,int close , int n , List<String> list , String str){

    //     if( str.length() == n*2){
    //         list.add(str);
    //         return;
    //     }

    //     if(open < n) solve(open+1 , close , n , list , str+"(" );
    //     if(close < open ) solve(open , close+1 , n , list , str+ ")" );
    // }
}