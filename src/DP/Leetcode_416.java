package DP;

public class Leetcode_416 {
    public static void main(String[] args) {
        test();
    }

    static void test() {
        // valid
        int[] test1 = new int[]{1,5,5,11};
        boolean b1 = canPartition(test1);
        System.out.println(b1);
        int[] test2 = new int[]{1,2,5,11};
        boolean b2 = canPartition(test2);
        System.out.println(b2);
        // invalid
        int[] invalid = new int[]{};
        boolean b3 = canPartition(invalid);
        System.out.println(b3);
    }

    /**
     * 子集背包问题-->0-1背包问题
     * @param nums
     * @return
     */
    static boolean canPartition(int[] nums) {
        if (nums.length == 0) return false;
        int sum = 0;
        for (int number: nums
             ) {
            sum += number;
        }
        // 背包和为奇数时，不可能进行划分
        if (sum % 2 != 0) return false;
        int N = sum / 2;
        int m = nums.length;
        // 1.状态: 背包重量 and 可以选择的物品
        // 1.1 选择: 将第i个物品放入背包 or 不放入背包
        // 2.dp数组定义：dp[i][j] 对于前i个物品，对于容量为j的背包，可以有一种方法把背包恰好装满
        boolean[][] dp = new boolean[m+1][N+1];
        // 1.1 base case: dp[0][...] = dp[...][0] = false, 没有放物品
        for (int i = 0; i <= N; i++)
            dp[0][i] = false;
        for (int i = 0; i <= m; i++)
            // 背包没有空间时，一定是装满了
            dp[i][0] = true;
        // 3.选择策略
        // 3.1. 不把第i个物品放入-> dp[i-1][j]
        // 3.2. 把第i个物品放入-> dp[i-1][j-nums[i-1]]：nums[i-1]为第i个物品的重量，
        // 3.3. 容量不足，不能装入-> dp[i-1][j]
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= N; j++) {
                if ((j - nums[i - 1]) >= 0) {
                    dp[i][j] = dp[i - 1][j] | dp[i-1][j - nums[i - 1]];
                } else {
                    // 背包容量不足
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][N];
}}
