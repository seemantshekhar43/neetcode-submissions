class Solution {

    // Time complexity: O(N * M)
    // Space complexity: O(M)
    // Bottom Up tabular approach 
    public int change(int amount, int[] coins) {
        Integer[] dp = new Integer [amount + 1];

        //dp[j] = ways to make amount j using all coins

        for(int i = coins.length; i >= 0; i--){
            for(int j = 0; j <= amount; j++){
                // 1 way to make amount 0
                if(j == 0){
                    dp[j] = 1;
                }
                // 0 ways to make amount using coins starting index coins.length
                else if(i == coins.length){
                    dp[j] = 0;
                }else{
                    // ways to make amount j - coins[i] starting index i given j-coins[i] is valid amount
                    int incl = j - coins[i] < 0 ? 0 : dp[j - coins[i]];
                    // ways to make amount j staring index i excluding current coin = previous value as current coin is not considered
                    int excl = dp[j];
                    
                    dp[j] = incl + excl;
                }
            }
        }

        // ways to get amount using all coins
        return dp[amount];
        
    }

    // // Time complexity: O(N * M)
    // // Space complexity: O(N * M)
    // // Bottom Up tabular approach 
    // public int change(int amount, int[] coins) {
    //     Integer[][] dp = new Integer[coins.length + 1][amount + 1];

    //     //dp[i][j] = ways to make amount j using coins starting from index i

    //     for(int i = coins.length; i >= 0; i--){
    //         for(int j = 0; j <= amount; j++){
    //             // 1 way to make amount 0
    //             if(j == 0){
    //                 dp[i][j] = 1;
    //             }
    //             // 0 ways to make amount using coins starting index coins.length
    //             else if(i == coins.length){
    //                 dp[i][j] = 0;
    //             }else{
    //                 // ways to make amount j - coins[i] starting index i given j-coins[i] is valid amount
    //                 int incl = j - coins[i] < 0 ? 0 : dp[i][j - coins[i]];
    //                 // ways to make amount j staring index i excluding current coin
    //                 int excl = dp[i + 1][j];
                    
    //                 dp[i][j] = incl + excl;
    //             }
    //         }
    //     }

    //     // ways to get amount using coin in the coins list starting index 0
    //     return dp[0][amount];
        
    // }

    // // Time complexity: O(N * M)
    // // Space complexity: O(N * M)
    // // Top down recursive approach
    // public int change(int amount, int[] coins) {
    //     Integer[][] dp = new Integer[coins.length][amount + 1];
    //     return traverse(0, amount, coins, dp);
        
    // }

    // public int traverse(int curr, int amount, int[] coins, Integer[][] dp){
    //     // 0 ways to get any amount less than 0
    //     if(amount < 0){
    //         return 0;
    //     }

    //     // found a way
    //     if(amount == 0){
    //         return 1;
    //     }

    //     // 0 ways to make amount with coins present after index coins.length - 1
    //     if(curr >= coins.length){
    //         return 0;
    //     }

    //     if(dp[curr][amount] != null){
    //         return dp[curr][amount];
    //     }

    //     // ways to get (amount - coins[curr]) using coins available after(including) index curr
    //     int incl = traverse(curr, amount - coins[curr], coins, dp);
    //     // ways to get amount using coins available after(excluding) index curr
    //     int excl = traverse(curr + 1, amount, coins, dp);

    //     //total ways to get amount using coins starting curr index. 
    //     return dp[curr][amount] = incl + excl;
    // }
}
