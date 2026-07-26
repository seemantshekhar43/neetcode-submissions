class Solution {


    //Time complexity: O(N*M)
    //Space complexity: O(M)
    public int coinChange(int[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];

        // dp[j] = Min. num of coins needed to make amount using all coins. 

        for(int i = coins.length; i >= 0; i--){
            for(int j = 0; j <= amount; j++){
                // amount == 0
                if(j == 0){
                    dp[j] = 0;
                }
                // there would be no coin at this index or after coins.length - 1
                else if(i == coins.length){
                    dp[j] = -1;
                }else{
                    // if amount (j - coins[i]) >= 0
                    int incl = j - coins[i] >= 0 ? dp[j - coins[i]] : -1;
                    // current value of dp[j] - without using the current coin
                    int excl = dp[j];
                    int min = Integer.MAX_VALUE;

                    // check if incl way is possible
                    if(incl != -1 ){
                        min = Math.min(incl + 1,  min);
                    }

                    //check if excl way is possible
                    if(excl != -1){
                        min = Math.min(excl, min);
                    }

                    dp[j] = (min == Integer.MAX_VALUE ? -1 : min);
                }
            }
        }

        return dp[amount];
    }
    
    // //Time complexity: O(N*M)
    // //Space complexity: O(N*M)
    // public int coinChange(int[] coins, int amount) {
    //     Integer[][] dp = new Integer[coins.length + 1][amount + 1];

    //     // dp[i][j] = Min. num of coins needed to make amount j using coins from index i onward.

    //     for(int i = coins.length; i >= 0; i--){
    //         for(int j = 0; j <= amount; j++){
    //             // amount == 0
    //             if(j == 0){
    //                 dp[i][j] = 0;
    //             }
    //             // there would be no coin at this index or after coins.length - 1
    //             else if(i == coins.length){
    //                 dp[i][j] = -1;
    //             }else{
    //                 // if amount (j - coins[i]) >= 0
    //                 int incl = j - coins[i] >= 0 ? dp[i][j - coins[i]] : -1;
    //                 int excl = dp[i + 1][j];
    //                 int min = Integer.MAX_VALUE;

    //                 // check if incl way is possible
    //                 if(incl != -1 ){
    //                     min = Math.min(incl + 1,  min);
    //                 }

    //                 //check if excl way is possible
    //                 if(excl != -1){
    //                     min = Math.min(excl, min);
    //                 }

    //                 dp[i][j] = (min == Integer.MAX_VALUE ? -1 : min);
    //             }
    //         }
    //     }

    //     return dp[0][amount];
    // }

    // public int coinChange(int[] coins, int amount) {
    //     Integer[][] dp = new Integer[coins.length][amount + 1];
    //     return traverse(0, amount, coins, dp);
    // }

    // public int traverse(int curr, int amount, int[] coins, Integer[][] dp){
    //     // base case
    //     if(amount == 0){
    //         return 0;
    //     }

    //     // not possible case
    //     if(amount < 0 || curr >= coins.length){
    //         return -1;
    //     }

    //     // total coins required to get sum amount starting index curr
    //     if(dp[curr][amount] != null){
    //         return dp[curr][amount];
    //     }

    //     // including current with repeat
    //     int incl = traverse(curr, amount - coins[curr], coins, dp);

    //     //excluding current
    //     int excl = traverse(curr + 1, amount, coins, dp);

    //     int min = Integer.MAX_VALUE;

    //     if(incl != -1 ){
    //         min = Math.min(incl + 1,  min);
    //     }

    //     if(excl != -1){
    //         min = Math.min(excl, min);
    //     }

    //     return dp[curr][amount] = (min == Integer.MAX_VALUE ? -1 : min);
    // }
}
