class Solution {
    public int minimumCost(int[] nums) {
        

        // List<Integer> list=  new ArrayList<>();
        // for(int i =1 ; i<nums.length ; i++){
        //     list.add(nums[i]);
        // }

        // Collections.sort(list);


        // return  (nums[0]+list.get(0)+list.get(1));


        int first = Integer.MAX_VALUE;
        int sec = Integer.MAX_VALUE;

        for(int  i =1 ; i <nums.length ; i++){
            if(nums[i] < first){
                sec = first;
                first = nums[i];
            }else if(nums[i]<sec) {
                sec = nums[i];
            }
        }

        return nums[0]+first+sec;
    }
}

//T.C -> O(N)
//S.C -> O(1)