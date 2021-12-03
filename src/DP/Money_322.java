package DP;

import java.util.Arrays;

/**
 * @author wuyuhan
 * @date 2021/12/1 21:35
 */
public class Money_322 {
    public static void main(String[] args) {
        test();
    }

    static void test() {
        // valid
        int amount = 11;
        int[] coins = {1,2,3,4,5};
        int res = coinChange2(coins, 11);

        System.out.println(res);
        // invalid
    }

    // 带备忘录的递归
    static int[] memo;
    static int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];

        Arrays.fill(memo, -996);
        // 1. base case
        // 2. 状态：目标金额
        // 3. 选择：所有硬币的面值
        // 4. 明确 dp函数/数组 定义
        // dp(n): 输入目标金额n，返回凑出金额n的最少硬币数量
        return dp(coins, amount);
    }
    static int dp(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        if (memo[amount] != -666)
            return memo[amount];


        int res = Integer.MAX_VALUE;

        for (int coin : coins) {
            int subProblem = dp(coins, amount - coin);
            if (subProblem == -1) continue;
            res = Math.min(res, subProblem + 1);
        }
        memo[amount] = (res == Integer.MAX_VALUE) ? -1: res;
        return memo[amount];
    }

    // dp 数组：当目标金额为 i 时(状态体现在索引)，需要dp[i]枚硬币凑出
    static int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        //
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin: coins) {
                if (i - coin < 0)
                    continue;
                dp[i] = Math.min(dp[i-coin] + 1, dp[i]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
