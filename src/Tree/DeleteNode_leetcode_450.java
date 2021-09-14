package Tree;

/**
 * @author wuyuhan
 * @date 2021/9/14 上午8:26
 */
public class DeleteNode_leetcode_450 {

    /**
     * function:在root为根的树中删除值为val的元素，并返回删除之后的根结点
     * 删除：
     *  1. 删除叶子结点->直接删除
     *  2. 删除有一个孩子的结点->让孩子取代它
     *  3. 删除有两个孩子的结点->
     *      (1)让右侧最小的结点或者左侧最大的结点取代它,交换值
     *      (2)删除右侧最小的结点
     * @param root
     * @param val
     * @return
     */
    static TreeNode deleteNode(TreeNode root, int val) {
        // base case
        if (root == null) return null;

        if (root.val == val) {
            // 1.
//            if (root.left == null && root.right == null)
//                return null;
            // 2.
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // 3. 去右子树中找最左结点 !!!!!
            TreeNode minNode = findMinNode(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);

        } else if (root.val > val) {
            root.left = deleteNode(root.left, val);
        } else {
            root.right = deleteNode(root.right, val);
        }
        return root;
    }

    /**
     * 找到BST中的最小结点
     *  一点是在左子树中
     * @param root
     * @return
     */
    static TreeNode findMinNode(TreeNode root) {
        TreeNode p = root;
        while(p.left != null) p = p.left;
        return p;
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
        TreeNode res = deleteNode(node10, 10);
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
