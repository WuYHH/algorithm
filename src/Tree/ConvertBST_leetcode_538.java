package Tree;

/**
 * @author wuyuhan
 * @date 2021/9/10 下午3:45
 */
public class ConvertBST_leetcode_538 {


    /**
     * BST的递归顺序修改
     * @param root
     * @return
     */
    static TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    /**
     * 函数功能：递归遍历以root为根的树，结点为累加的和
     * @param root
     */
    static int sum = 0;
    static void traverse(TreeNode root) {
        // base
        if (root == null) return;

        // 倒序遍历
        traverse(root.right);
        // 对当前结点累加和
        sum += root.val;
        root.val = sum;
        traverse(root.left);
    }

    static void test() {
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

        TreeNode root = convertBST(node5);
    }
    public static void main(String[] args) {
        test();
    }
}
