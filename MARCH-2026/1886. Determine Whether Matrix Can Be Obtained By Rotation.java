class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        for(int r = 0; r < 4; r++) {

            // check equal
            if(check(mat, target)) return true;

            // rotate 90 deg

            // transpose
            for(int i = 0; i < n; i++){
                for(int j = i; j < n; j++){
                    int temp = mat[i][j];
                    mat[i][j] = mat[j][i];
                    mat[j][i] = temp;
                }
            }

            // reverse each row
            for(int i = 0; i < n; i++){
                int left = 0, right = n-1;
                while(left < right){
                    int temp = mat[i][left];
                    mat[i][left] = mat[i][right];
                    mat[i][right] = temp;
                    left++;
                    right--;
                }
            }
        }

        return false;
    }

    public boolean check(int[][] mat, int[][] target){
        int n = mat.length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] != target[i][j]) return false;
            }
        }
        return true;
    }
}