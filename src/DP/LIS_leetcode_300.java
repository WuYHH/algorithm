package DP;

import java.util.Arrays;

/**
 * @author wuyuhan
 * @date 2021/12/3 21:22
 */
public class LIS_leetcode_300 {
    public static void main(String[] args) {
        test();
    }
    static void test() {
        // invalid: len = 0;
        int[] nums1 = {};
        // valid
        int[] nums2 = {1,2,3};
        int res = lengthOfLIS(nums2);
        System.out.println(res);
    }

    /**
     * 复杂度太高：O(n^2)
     * @param nums
     * @return
     */
    static int lengthOfLIS(int[] nums) {
        //
        if (nums.length == 0) return 0;

        // 1.状态：以nums[i]为结尾的有序字符串在变化，
        // 2.dp数组，索引即为状态；dp[i]
        // 3.base case: 如果只有一个元素，一定是他自己
        // 4.转移方程,想一下比他小的状态怎么变化：dp[i] = max{dp[i], dp[j]+1}, 找到比当前dp[i]小的子序列，把当前接上
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, 1);
        int res = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 若找到，则更新，找不到就算了
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * 贪心实际是最接近人的理解的方法，我们的难点是怎么将思维整理并转化为代码实现。
     *
     * 先不考虑题解， 假如给出序列 mylist=[1， 3， 5， 6， 7， 2， 5， 7， 9， 10]，我们肉眼来找最长序列的时候，看到1, 3, 5, 6, 7递增，长度len1=5，我们怀疑这个就是目标序列，暂且记为答案一。 但是当遇到2(mylist[5])时，我们就考虑另一种答案，有没有可能从1, 2, ... (mylist[0], mylist[5]...)会找到一个新的子序列， 且比之前找的序列1, 3, 5, 6, 7更长呢？（记为答案二）我相信大部分人分析题目时，会有这个想法
     *
     * 接下来，当我们继续验证答案二时，需要依赖2以后的数字，看是否能找到新的递增序列。
     *
     * 然而，我们的目的是找最长的长度， 有两种结果，新的答案比第一次的答案短， 则我们保留原始答案一， 新的答案比第一次的答案长， 我们用新的方案。 但是过程我们要记录， 1）我新的答案，找到哪个数字了，以便继续往下找 2）如果新的答案不够长，保留答案一的结果。 回到题解，当我找到2时， 新的答案，第二个数字是2， 原来的[1, 3, 5, 6, 7], 3已经不在我新的答案序列了，我就把3替换为2， 依次进行， 如果我新的答案比第一次答案长， 整个序列被替换，如果没有第一个长，我替换的次数不够，原来方案一里最大的数字还在末尾， 原始的d的长度不会被替换。
     *
     * 那么我们始终能用d的长度表示我们的结果。
     * @param nums
     * @return
     */
    static int dp_binaryTree(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] d = new int[n + 1];
        // d[i] 为长度为i的最长上升子序列末尾的最小值，
        d[len] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > d[len]) {
                d[++len] = nums[i];
            } else {
                // 从d数组找一个位置
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (d[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                d[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
