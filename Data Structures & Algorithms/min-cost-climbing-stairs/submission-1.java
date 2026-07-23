class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Integer[] dp = new Integer[cost.length];
        return Math.min(traverse(0, cost, cost.length, dp), traverse(1, cost, cost.length, dp));
    }

    public int traverse(int curr, int[] cost, int n, Integer[] dp){
        
        //Invalid state return Integer.MAX_VALUE
        if(curr > n){
            return Integer.MAX_VALUE;
        }

        //Reached destination return 0
        if(curr == n){
            return 0;
        }

        // Minimum cost to reach to the top from curr
        if(dp[curr] != null){
            return dp[curr];
        }


        // We have two choices either go 1 step from here or 2 step
        int one = traverse(curr + 1, cost, n, dp);
        int two = traverse(curr + 2, cost, n, dp);

        int totalCost = cost[curr] + Math.min(one, two);

        return dp[curr] = totalCost;
    }
}
