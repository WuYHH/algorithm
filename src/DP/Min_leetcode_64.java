package DP;

/**
 * @author wuyuhan
 * @date 2021/12/10 21:21
 */
public class Min_leetcode_64 {
    public static void main(String[] args) {
        test();
    }

    static void test() {
        // invalid
        int[][] test1 = {};
        int result = minPathSum(test1);
        System.out.println(result);
        int[][] test2 = new int[][]{{1,3,1},{1,5,1},{4,2,1}};

        int result2 = minPathSum(test2);
        System.out.println(result2);
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        if (m <= 0)
            return 0;
        int n = grid[0].length;
        if (n <= 0)
            return 0;
        return dp(grid, m, n);
    }

    /**
     * 1. 状态: 不断变化的是最小路径和
     *
     * 2. dp数组定义
     *      当（0，0）走到（i，j）时，dp[i][j] 是最小路径和
     * 3. base case
     *      i = j = 0, path = grid[0][0]
     * 4. 状态转移方程：
     *  dp[i][j] = min{dp[i-1][j], dp[i][j-1]} + grid[i][j]
     * @param grid
     * @param m
     * @param n
     * @return
     */
    static int dp(int[][] grid, int m, int n) {
        // base case
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // 当i or j == 0，出现索引越界(i-1)
        for (int i = 1; i < m; i++)
            dp[i][0] = dp[i-1][0] + grid[i][0];
        for (int j = 1; j < n; j++)
            dp[0][j] = dp[0][j-1] + grid[0][j];

        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])
                        + grid[i][j];
            }
        }

        return dp[m-1][n-1];
    }
}
