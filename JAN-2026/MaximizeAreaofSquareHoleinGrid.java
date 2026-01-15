import java.util.Arrays;

class MaximizeAreaofSquareHoleinGrid {

    public static void main(String[] args) {
        
        int n = 5;
        int m = 5;
        int[] hBars = {2, 1, 4};
        int[] vBars = {2, 3};
        int result = maximizeSquareHoleArea(n, m, hBars, vBars);
        System.out.println("Maximum Area of Square Hole: " + result); 
    }
    public static int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        
        Arrays.sort(hBars);
        Arrays.sort(vBars);

        int maxDiffHorzi = 0;
        int curr = 0;
        int maxDiffVerti = 0;

        for(int i = 1 ; i <hBars.length ; i++ ){
            if(hBars[i] == hBars[i-1]+1){
                curr++;
                maxDiffHorzi = Math.max(curr,maxDiffHorzi);
            }else curr = 0;
        }
        curr = 0;
        for(int i = 1 ; i <vBars.length ; i++ ){
            if(vBars[i] == vBars[i-1]+1){
                curr++;
                maxDiffVerti = Math.max(curr,maxDiffVerti);
            }else curr = 0;
        }
        int res = Math.min(maxDiffVerti , maxDiffHorzi)+2;
        return res*res;
    }
}