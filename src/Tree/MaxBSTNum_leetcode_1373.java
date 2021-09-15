package Tree;

/**
 * @author wuyuhan
 * @date 2021/9/15 上午8:55
 * notes:
 *  traverse把辅助函数的事情做掉！以数组形式
 */
public class MaxBSTNum_leetcode_1373 {

    public static int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    /**
     * 遍历二叉树，返回int[]{isBST, min, max, sum}
     *  isBST:是否是二叉树,1:是. 2:否
     *  min:以root为根的二叉树的最小值
     *  max:以root为根的二叉树的最大值
     *  sum:以root为根的二叉树的结点总数
     *
     * @param root
     * @return
     */
    static int maxSum = 0;
    public static int[] traverse(TreeNode root) {
        // base case:叶子节点
        // 叶子结点也为BST
        if (root == null)
            // Math.min() 和Math.max()必须分会root.val,最小值是root，最大值也是root
            return new int[] {1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int[] left = traverse(root.left);
        int[] right = traverse(root.right);

        int[] res = new int[4];
        // root要做的事？什么时候做？
        // 1.判断子树BST的合法性->
        if (left[0] == 1 && right[0] == 1
            && root.val > left[2] && root.val < right[1]) {
            // 是二叉树
            res[0] = 1;
            // 以root为根的BST的最小值
            res[1] = Math.min(left[1], root.val);
            // 以root为根的BST的最大值
            res[2] = Math.max(right[2], root.val);
            // 计算所有节点数之和
            res[3] = left[3] + right[3] + root.val;
            //
            maxSum = Math.max(maxSum, res[3]);
        } else {
            // 不是BST
            res[0] = 0;
            // 其他的不用搞
        }
        // 2.加上root根结点是否是合法的BST->
        // 3.以root为根结点的BST的结点数是多少
    return res;

    }


    static void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node4.left = node3;
        node3.left = node1;
        node3.right = node2;

        int res = maxSumBST(node4);
        System.out.println(res);
    }
    public static void main(String[] args) {
        test();
    }
}
