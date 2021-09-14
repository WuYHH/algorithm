package Tree;

/**
 * @author wuyuhan
 * @date 2021/9/14 上午8:15
 */
public class InsertIntoBST_leetcode_701 {

    /**
     * function: 向以root为根的二叉树里插入值为val的结点，并返回插入后的二叉树的头
     * @param root
     * @param val
     * @return
     */
    static TreeNode insertIntoBST(TreeNode root, int val) {
        // base case
        if (root == null) return new TreeNode(val);

        if (root.val > val)
            // 左子树插入完后，返回左子树的根结点
            root.left = insertIntoBST(root.left, val);
        else if (root.val < val)
            // 右子树插入完后，返回右子树的根结点
            root.right = insertIntoBST(root.right, val);
        return root;
    }


    public static void test() {
        // valid
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node15 = new TreeNode(15);
        TreeNode node6 = new TreeNode(6);
        TreeNode node20 = new TreeNode(20);
        TreeNode node12 = new TreeNode(12);

        TreeNode singleNode = new TreeNode(9999);
        // invalid
        TreeNode nullNode = null;

        node10.left = node5;
        node10.right = node15;
//        node15.left = node6;
        node15.left = node12;
        node15.right = node20;

//        boolean res = isInBST(node10, 10);
        TreeNode res = insertIntoBST(node10, 9);
        print(res);
    }

    public static void print(TreeNode root) {
        if (root == null) return;
        print(root.left);
        System.out.println(root.val);
        print(root.right);
    }
    public static void main(String[] args) {
        test();
    }
}
