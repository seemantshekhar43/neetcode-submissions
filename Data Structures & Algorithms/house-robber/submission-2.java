class Solution {
    public int rob(int[] nums) {
        
        int incl = 0;
        int excl = 0;
        int maxSum = nums[0];

        for(int num : nums){
            //Include the current
            int newIncl = excl + num;

            //Exclude the current
            int newExcl = Math.max(incl, excl);

            maxSum = Math.max(newIncl, newExcl);
            incl = newIncl;
            excl = newExcl;

        }
        return maxSum;
    }

    // public int traverse(int curr, int[] nums, Integer[] dp){
    //     if(curr >= nums.length){
    //         return 0;
    //     }
        
    //     // Maximum money that can be collected starting curr
    //     if(dp[curr] != null) {
    //         return dp[curr];
    //     }

    //     int incl = nums[curr] + traverse(curr + 2, nums, dp);
    //     int excl = traverse(curr + 1, nums, dp);

    //     return dp[curr] = Math.max(incl, excl);
    // }
}
