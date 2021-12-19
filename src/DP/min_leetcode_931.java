package DP;

public class min_leetcode_931 {
    public static void main(String[] args) {
        test();
    }

    static void test() {
        // valid
        int[][] matrix = new int[][]{{1,1,1},{5,3,1},{2,3,4}};
        // invalid
        int[][] matrix1 = new int[][]{{1,1},{5,3},{2,3}};

        min_leetcode_931 main = new min_leetcode_931();
        int res = main.minFallingPathSum(matrix);
        System.out.println(res);

    }

    /**
     * 利用原数组进行动态规划,从下而上
     * @param matrix
     * @return
     */
    int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m <= 0) return -1;
        if (m != n)
            return -1;
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                int best = matrix[i+1][j];
                // 边界值
                if (j > 0)
                    best = Math.min(best, matrix[i+1][j-1]);
                if (j + 1 < m)
                    best = Math.min(best, matrix[i+1][j+1]);
                matrix[i][j] += best;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int x : matrix[0])
            ans = Math.min(ans, x);
        return ans;
        // base case
        // 1.状态 变化的坐标
        // 2.状态转移
        // "自下而上"
        // 3.dp. dp[i][j] 表示为从(i, j) 的元素开始下降的最小和。->(r+1,r-1),(r+1,c),(r+1,c+1)

    }

}
