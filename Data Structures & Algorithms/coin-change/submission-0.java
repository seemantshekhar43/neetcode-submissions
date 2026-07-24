class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[][] dp = new Integer[coins.length][amount + 1];
        return traverse(0, amount, coins, dp);
    }

    public int traverse(int curr, int amount, int[] coins, Integer[][] dp){
        // base case
        if(amount == 0){
            return 0;
        }

        // not possible case
        if(amount < 0 || curr >= coins.length){
            return -1;
        }

        // total coins required to get sum amount starting index curr
        if(dp[curr][amount] != null){
            return dp[curr][amount];
        }

        // including current with repeat
        int incl = traverse(curr, amount - coins[curr], coins, dp);

        //including current without repeat
        int inclNoRepeat = traverse(curr + 1, amount - coins[curr], coins, dp);

        //excluding current
        int excl = traverse(curr + 1, amount, coins, dp);

        int min = Integer.MAX_VALUE;

        if(incl != -1 ){
            min = Math.min(incl + 1,  min);
        }

        if(inclNoRepeat != -1){
            min = Math.min(inclNoRepeat + 1, min);
        }

        if(excl != -1){
            min = Math.min(excl, min);
        }

        return dp[curr][amount] = (min == Integer.MAX_VALUE ? -1 : min);
    }
}
