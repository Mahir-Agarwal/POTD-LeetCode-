class Solution {
    public int countCommas(int n) {
        if(n<1000){
            return 0;
        }
        // int count = 0;
        // for(int i=1000;i<=n;i++){
        //     if(  ((int) (Math.log10(i)+1 ) ) % 3 ==0){
        //         count++;
        //     }
        // }
        return n - 999;
    }
}