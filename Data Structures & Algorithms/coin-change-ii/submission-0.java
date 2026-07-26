class Solution {

    // Time complexity: O(N * M)
    // Space complexity: O(N * M)
    // Top down recursive approach
    public int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length][amount + 1];
        return traverse(0, amount, coins, dp);
        
    }

    public int traverse(int curr, int amount, int[] coins, Integer[][] dp){
        // 0 ways to get any amount less than 0
        if(amount < 0){
            return 0;
        }

        // found a way
        if(amount == 0){
            return 1;
        }

        // 0 ways to make amount with coins present after index coins.length - 1
        if(curr >= coins.length){
            return 0;
        }

        if(dp[curr][amount] != null){
            return dp[curr][amount];
        }

        // ways to get (amount - coins[curr]) using coins available after(including) index curr
        int incl = traverse(curr, amount - coins[curr], coins, dp);
        // ways to get amount using coins available after(excluding) index curr
        int excl = traverse(curr + 1, amount, coins, dp);

        //total ways to get amount using coins starting curr index. 
        return dp[curr][amount] = incl + excl;
    }
}
