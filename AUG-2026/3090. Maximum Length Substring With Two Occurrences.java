 class Solution {
    public int maximumLengthSubstring(String s) {
        
        int i = 0 ;
        int j = 0 ;
        int map[] = new int [26];

        int max =0;
        while (j < s.length()) {
            int idx = s.charAt(j) -'a';
            map[idx]++;

            while( map[idx] > 2 ){
                int index = s.charAt(i)-'a';
                map[index]--;
                i++;
            }

            max =Math.max(max , j-i+1);
            j++;
        }
        return max ;
    }
}
T.C -> O(n);
S.C -> O(1);