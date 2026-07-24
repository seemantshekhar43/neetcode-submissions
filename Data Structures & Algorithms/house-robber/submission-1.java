class Solution {
    public int rob(int[] nums) {
        //Include the current or exclude it and solve the remaining subproblem
        Integer[] dp = new Integer[nums.length];
        return traverse(0, nums, dp);



    }

    public int traverse(int curr, int[] nums, Integer[] dp){
        if(curr >= nums.length){
            return 0;
        }
        
        // Maximum money that can be collected starting curr
        if(dp[curr] != null) {
            return dp[curr];
        }

        int incl = nums[curr] + traverse(curr + 2, nums, dp);
        int excl = traverse(curr + 1, nums, dp);

        return dp[curr] = Math.max(incl, excl);
    }
}
