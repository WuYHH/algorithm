package DP;

public class LeetCode_494 {
    public static void main(String[] args) {
        test();
    }

    static void test() {
        // invalid
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        findTargetSumWays(nums, target);
        System.out.println(result);
        // valid

    }

    /**
     * 回溯方法：
     *  模板：
     *  复杂度：O(2^n):为树的节点数
     * @param nums
     * @param target
     * @return
     */
    static int result = 0;
    static int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) return 0;
        backtrack(nums, 0, target);
        return result;
    }

    static void backtrack(int[] nums, int i, int rest) {
        // base case
        if (i == nums.length) {
            if (rest == 0)
                result ++;
            return;
        }

        // nums[i] 取 -
        rest += nums[i];
        // 穷举 nums[i+1]
        backtrack(nums, i+1, rest);
        // 撤销选择
        rest -= nums[i];

        // nums[i] 取 +
        rest -= nums[i];
        // 穷举 nums[i+1]
        backtrack(nums, i+1, rest);
        // 撤销选择
        rest += nums[i];
    }
}
