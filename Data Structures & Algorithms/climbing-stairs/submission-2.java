class Solution {
    public int climbStairs(int n) {
        Integer[] dp = new Integer[n];
        return traverse(0, n, dp);
    }

    public int traverse(int curr, int n, Integer[] dp){
        //not a valid state so return 0
        if(curr > n){
            return 0;
        }

        //reached top, so it counts as 1 way
        if(curr == n){
            return 1;
        }

        // No. of ways to reach top from curr
        if(dp[curr] != null){
            return dp[curr];
        }
        
        // Have two options either take one step or two step. No. of ways to reach top after taking 1 step and 2 step
        int one = traverse(curr + 1, n, dp);
        int two = traverse(curr + 2, n, dp);
        return dp[curr] = one + two;
    }
}
