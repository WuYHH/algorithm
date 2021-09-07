package Tree;

/**
 * @author wuyuhan
 * @date 2021/9/7 下午6:44
 */
public class MaximumBinaryTree_leetcode_645 {


    /**
     * 递归构建以nums为根结点最大二叉树并返回根结点
     * @param nums
     * @return
     */
    static TreeNode constructMaximumBinaryTree(int[] nums){

        return build(nums, 0, nums.length - 1);
    }

    static TreeNode build(int[] nums, int left, int right) {
        // base case
        if (left > right) return null;
        // 1.找到数组中的最大结点和索引
        int index = -1;
        int maxValue = Integer.MIN_VALUE;
        // i < left
        for (int i = left; i <= right; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }
        // 最大根结点
        TreeNode head = new TreeNode(maxValue);
        head.left = build(nums, left, index - 1);
        head.right = build(nums,index + 1, right);

        return head;
    }

    public static void test01() {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode res = constructMaximumBinaryTree(nums);
        print(res);
    }
    public static void print(TreeNode treeNode) {
        if (treeNode == null) return;
        System.out.println(treeNode.val);
        print(treeNode.left);
        print(treeNode.right);
    }
    public static void main(String[] args) {
        test01();
    }
}
