package Tree;

import Utils.MyUtils;

/**
 * @author wuyuhan
 * @date 2021/9/18 上午7:42
 */
public class CountNodes_leetcode_222 {

    /**
     * 计算完全二叉树的节点数
     * @param root
     * @return
     */
    static int countNodes(TreeNode root) {
        //Utils.TreeNode d = root;

        // base case
        if (root == null) return 0;

        TreeNode l = root, r = root;
        int left = 0, right = 0;
        while(l != null) {
            left ++;
            l = l.left;
        }
        while (r != null) {
            right ++;
            r = r.right;
        }
        // 满二叉树
        if (left == right)
            return (int)Math.pow(2, left) - 1;
        // 使用普通二叉树的结点求法
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    static void test() {
//        Utils.TreeNode root = MyUtils.getTree("1,2,3,4,5,null,null");
//        MyUtils.print(root.);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        // single node
        TreeNode singleNode = new TreeNode(999);

        // null node
        TreeNode nullNode = new TreeNode(-1);
        
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        System.out.println(countNodes(node1));
    }

    public static void main(String[] args) {
        test();
    }
}
