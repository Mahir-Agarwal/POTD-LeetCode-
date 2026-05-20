class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashMap<Integer, Integer> map =new HashMap<>();

        int res[] = new int [A.length];

        int freq [] = new int [A.length+1];
        for(int i =0 ; i < A.length ;i++){
            freq[A[i]]++;
            freq[B[i]]++;
            int count= 0 ;
            for(int k=0 ; k < freq.length ; k++){
                if(freq[ k] >=2)  count++;
            } 
            res[i] = count;
        }

        return res ;
    }
}