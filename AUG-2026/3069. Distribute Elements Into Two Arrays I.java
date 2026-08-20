class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1.add(nums[0]);
        list2.add(nums[1]);
        int first = nums[0];
        int sec = nums[1];

        for(int i = 2 ; i < nums.length ; i++){

            if(first > sec){
                list1.add(nums[i]);
                first = nums[i];
            }else{
                list2.add(nums[i]);
                sec = nums[i];
            }
        }
        int res[] = new int [list1.size()+list2.size()];
        int i = 0 ;
        
        for(int x : list1) res[i++] = x;
        for(int x : list2) res[i++] = x;

        return res ; 
    }
}