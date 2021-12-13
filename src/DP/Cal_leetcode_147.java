package DP;

import java.util.Arrays;

public class Cal_leetcode_147 {
    public static void main(String[] args) {
        test();
    }

    static void test() {
        int[][] test2 = new int[][]{{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int res = calculateMinimumHP(test2);
        System.out.println(res);
    }

    /**
     * 从右下->左上进行动态规划,反向动态规划
     * @param grid
     * @return
     */
    static int calculateMinimumHP(int[][] grid) {
        int m = grid.length;
        if (m <= 0) return 0;
        int n = grid[0].length;
        if (n <= 0) return 0;
        int[][] dp = new int[m+1][n+1];
        // base case
        for (int i = 0; i <= n; ++i) {
            // dp[n]设置为Integer.MAX_VALUE是为了统一最后一列与其他列操作
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // 1. 状态: 骑士的生命值
        // 2. 数组定义:dp[i][j] 需要知道到达B点的生命值而不是最小值。
        //        dp[i][j]为到达左上角的生命值的最小值
        // 3. 状态转移方程:
        dp[n][m-1] = dp[n-1][m] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minn, 1);
            }
        }
        return dp[0][0];
    }

}
