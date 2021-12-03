package DP;
import java.util.*;
/**
 * @author wuyuhan
 * @date 2021/11/25 22:36
 */
public class Fib_509 {
    public static void main(String[] args) {
        System.out.println("....");
        test();
    }
    public static void test() {
        int n = 1;
//        int n = 1;
//        int n = -1;
//        int n = 2;
        int res = fib4(n);
        System.out.println(res);

    }

    /*
      3种方式实现：
    * 1. 递归
    * 2. 备忘录
    * 3. 动态规划
    * */
    // 1. 存在大量的冗余节点
    static int fib1(int n) {
        if (n == 1 || n == 2)
            return n;
        return fib1(n - 1) + fib1(n - 2);
    }
    // 2. 备忘录
    static int fib2(int n) {
        int memo[] = new int[n + 1];
        return helper(n, memo);
    }
    static int helper(int n, int[] memo) {
        if (n == 1 || n == 2)
            return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
        return memo[n];
    }

    // 3. dp数组的迭代解法
    static int fib3(int N) {
        if (N == 0) return 0;
        int[] dp = new int[N + 1];
        // base case
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    // 4. 状态压缩：O(n^2)->O(n)
    static int fib4(int N) {
        if (N == 0) return 0;
        if (N == 1 || N == 2)
            return 1;
        int pre = 1, curr = 1;
        for (int i = 3; i <= N; i++) {
            int sum = pre + curr;
            pre = curr;
            curr = sum;

        }
        return curr;
    }
}
