class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            int diff = A[i] - A[i - 1];
            if (diff < minDiff) {
                minDiff = diff;
                res = new ArrayList<>();
                res.add(Arrays.asList(A[i - 1], A[i]));
            } else if (diff == minDiff) {
                res.add(Arrays.asList(A[i - 1], A[i]));
            }
        }

        return res;
    }
}
//T.C -> O(n log n) due to sorting
//S.C -> O(1) if we don't consider the output list
