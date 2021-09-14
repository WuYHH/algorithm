package Tree;

/**
 * @author wuyuhan
 * @date 2021/9/14 上午8:02
 */
public class IsInBST_leetcode_700 {

    /**
     * 判断以root为结点的根，target是否在这棵树内,返回结果
     * @param root
     * @param target
     * @return
     */
    static boolean isInBST(TreeNode root, int target) {
        // base case
        if (root == null) return false;
        // 当前root要做的？
        if (root.val < target)
            return isInBST(root.right, target);
        else if (root.val > target)
            return isInBST(root.left, target);
        else
            return true;
    }


    public static void test() {
        TreeNode node10 = new TreeNode(10);
        TreeNode node5 = new TreeNode(5);
        TreeNode node15 = new TreeNode(15);
        TreeNode node6 = new TreeNode(6);
        TreeNode node20 = new TreeNode(20);
        TreeNode node12 = new TreeNode(12);

        TreeNode nullNode = null;

        node10.left = node5;
        node10.right = node15;
//        node15.left = node6;
        node15.left = node12;
        node15.right = node20;

//        boolean res = isInBST(node10, 10);
        boolean res = isInBST(node10, 9);
        if (res)
            System.out.println("yep");
        else
            System.out.println("false");
    }
    public static void main(String[] args) {
        test();
    }
}
