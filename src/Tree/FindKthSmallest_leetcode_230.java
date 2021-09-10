package Tree;

/**
 * @author wuyuhan
 * @date 2021/9/10 下午2:36
 */
// 新数据结构，用于优化为O(logN)

public class FindKthSmallest_leetcode_230 {

    /**
     * 时间复杂度分析：O(N),由于BST的性质，可以优化为O(logN)
     * @param root
     * @param k 第k小
     * @return
     */
    static int findKthSmallest(TreeNode root, int k) {
        int nodeSum = totalNum(root);
        if (k < 1 || k > nodeSum) return 0;

        find(root, k);
        return res;
    }
    static int res = 0;
    // 记录当前元素排名
    static int flag = 0;

    /**
     * 递归的寻找第k小的元素，采用中序遍历
     * @param root
     * @param k
     */
    static TreeNode find(TreeNode root, int k) {
        // base case
        if (root == null) return null;

        find(root.left, k);
        // 当前结点要做的
        flag++;
        if (flag == k) {
//            res = root.val;
            return root;
        }
        find(root.right, k);
        return null;
    }

    /**
     * 改进为O(logN)
     * 1. 确定当前结点的排名m(重点)，查找排名为k的结点
     * 2. 比较 m 和 k，if k < m, 去当前结点的左子树寻找第k个结点;
     *               if k > m，去右子树寻找第k-m-1个结点
     * @param root
     * @param k
     * @return
     */
    static TreeNode findKthSmallest1(TreeNode root, int k) {
        // base case
        if (root == null) return null;
        // 当前结点的排名
        int m = totalNum(root.left);
        if(m == k) {
            // 返回当前结点
            return root;
        } else if (m > k) {
            // 寻找左子树当中第k个结点
            return find(root.left, k);
        } else {
            // 寻找右子树当中第k-m-1个结点
            return find(root.right, k - m - 1);
        }
    }

    /**
     * 获取以root为根的二叉树的结点总数，返回当前的结点总数，采用后序遍历
     * @param root
     */
    static int totalNum(TreeNode root) {
        // base
        if (root == null) return 0;
        int leftNum = totalNum(root.left);
        int rightNum = totalNum(root.right);

        return leftNum + rightNum + 1;
    }

    public static void test() {
        // valid
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);

        node5.left = node3;
        node5.right = node6;
        node3.left = node2;
        node3.right = node4;
        node2.left = node1;
        TreeNode singleNode = new TreeNode(-1);
        // valid k
        int k = 3;
        // invalid k
        int k1 = 0;
        int k2 = 10;
//        int res = findKthSmallest(node5, k);
//        int res1 = findKthSmallest(node5, k2);
//        System.out.println(res1);
        TreeNode res = findKthSmallest1(node5, 3);
        System.out.println(res.val);
    }

    public static void main(String[] args) {
        test();
    }
}
