package Tree;

/**
 * @author wuyuhan
 * @date 2021/9/14 上午7:47
 */
public class IsValidBST_leetcode_98 {

    /**
     * 增加参数列表，携带额外信息，将约束传递到左右子树，而不是左右孩子
     * @param root
     * @return
     */
    static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /**
     *
     * function : 判断以root为根的二叉树，在min和max的范围内是否是BST
     * @param root
     * @param min
     * @param max
     * @return
     */
    static boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null) return true;

        if (min != null && root.val < min.val) return false;
        if (max != null && root.val > max.val) return false;

        // 限定左子树最大值是root.val, 右子树最小为root.val
        return isValidBST(root.left, min, root) &&
                isValidBST(root.right, root, max);
    }


    public static void test() {
        // valid
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node15 = new TreeNode(15);
        TreeNode node6 = new TreeNode(6);
        TreeNode node20 = new TreeNode(20);
        TreeNode node12 = new TreeNode(12);
        // single node
        TreeNode singNode = new TreeNode(9999);
        // null node
        TreeNode nullNode = null;

        node10.left = node5;
        node10.right = node15;
//        node15.left = node6;
        node15.left = node12;
        node15.right = node20;

//        boolean res = isValidBST(node10);
//        boolean res = isValidBST(singNode);
        boolean res = isValidBST(nullNode);
        if (res)
            System.out.println("yep");
        else
            System.out.println("false");
    }

    public static void main(String[] args) {
        test();
    }
}
