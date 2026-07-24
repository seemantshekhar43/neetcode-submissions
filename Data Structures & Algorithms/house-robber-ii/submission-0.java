class Solution {
    public int rob(int[] nums) {
        // 2, 9, 8, 3, 6, 2...
        // Either first or last can be taken not both
        // i = 0 to i = n - 1 and i = 1 to i = n

        if(nums.length == 1){
            return nums[0];
        }

        int statsWithFirst = normalRob(0, nums.length - 1, nums);
        int statsWithSecond = normalRob(1, nums.length, nums);

        return Math.max(statsWithFirst, statsWithSecond);     
                
    }

    public int normalRob(int start, int end, int[] nums){
        int incl = 0;
        int excl = 0;

        int maxSum = nums[start];

        for(int i = start; i < end; i++){
            int newIncl = nums[i] + excl;
            int newExcl = Math.max(incl, excl);

            maxSum = Math.max(newIncl, newExcl);
            incl = newIncl;
            excl = newExcl;
        }

        return maxSum;
    }
}
