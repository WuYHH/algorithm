package Tree;

/**
 * @author wuyuhan
 * @date 2021/9/16 下午6:34
 */
public class FindCommonAncestor_leetcode_236 {


    /**
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
   static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 后序
        // case 1
        if (left != null && right != null) {
            return root;
        }
        // case 2
        if (left == null && right == null) {
            return null;
        }
        // case 3
        return left == null ? right : left;

    }


    static void test() {
        // valid, 可以考虑用层序遍历来写数组？
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);

        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;

        //invalid

        TreeNode res = lowestCommonAncestor(node3, node5, node1);
        System.out.println(res.val);
    }
    public static void main(String[] args) {
        test();
    }
}
