package Tree;

/**
 * @author wuyuhan
 * @date 2021/9/14 下午5:59
 * notes:
 * 1.构建辅助数组:将numTree(n)问题->numTree(low,high)问题
 * 2.如何分析BST个数：
 *  （1）穷尽每一个root结点
 *  （2）对于当前root结点，分析其左区间[low, index-1]和[index+1, high]的树的形态的情况
 *  （3）推导出个数的公式 num = leftNum * rightNum;
 */
public class NumBST_leetcode_96 {

    /**
     * @param n
     * @return
     */
    // 增加备忘录
    static int[][] memo;
    static int numTree(int n) {
//        memo = new int[n+1][n+1];
        return numTree(1, n);
    }

    /**
     * numTree的辅助数组
     * function: 返回区间为[low, high]构建的BST的数量
     * @param low
     * @param high
     * @return
     */
    static int numTree(int low, int high) {
        // base case:1 而不是 0
        if (low > high) return 1;

        // 查备忘录
        if(memo[low][high] != 0)
            return memo[low][high];

        // root要做的事：穷尽low~high中的每一个root节点
        int res = 0;
        for (int i = low; i <= high; i++) {
            int left = numTree(low, i - 1);
            int right = numTree(i + 1, high);
            res += left * right;
        }

        // 将结果存入备忘录
        memo[low][high] = res;
        return res;
    }
    public static void test() {
        int res = numTree(3);
        System.out.println(res);
    }

    public static void main(String[] args) {
        test();
    }
}
