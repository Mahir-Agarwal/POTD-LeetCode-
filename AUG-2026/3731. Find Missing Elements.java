class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        if(nums.length  == 0 ) return new ArrayList<>();

        boolean present[] = new boolean[101];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        List<Integer> list =new ArrayList<>();

        for(int i = 0  ;i < nums.length ; i++){

            min =Math.min(min , nums[i]);
            max = Math.max(max , nums[i]);

            present[nums[i]] = true ; 
        }

        for(int i = min ; i <= max ; i++){
            if(!present[i]) list.add(i);
        }

        return list ;
    }
}


