package Tree;

/**
 * @author wuyuhan
 * @date 2021/9/8 下午3:11
 */

/*
* 1),明确递归定义
* 2),base case
* */
public class BuildTree_PreInOrder_leetcode_105 {

    public static TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder.length == 0 || inOrder.length == 0)
            return null;
        return build(preOrder, 0, preOrder.length-1,
                     inOrder, 0, inOrder.length-1);
    }

    /**
     * 根据前序和中序遍历构造二叉树，并返回二叉树的根结点
     * @param preOrder
     * @param preStart
     * @param preEnd
     * @param inOrder
     * @param inStart
     * @param inEnd
     * @return
     */
    public static TreeNode build(int[] preOrder, int preStart, int preEnd,
                                 int[] inOrder, int inStart, int inEnd) {
        // base case
        if (inStart > inEnd)
            return null;

        int rootVal = preOrder[preStart];
        int rootIndex = 0;
        // 找到root的index
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inOrder[i]) {
                rootIndex = i;
                break;
            }
        }
        // 构造根结点
        TreeNode root = new TreeNode(rootVal);
        int leftSize = rootIndex - inStart;
        root.left = build(preOrder, preStart + 1,
                preStart + leftSize, inOrder, inStart, rootIndex - 1);
        root.right = build(preOrder, preStart + leftSize + 1,
                preEnd, inOrder, rootIndex + 1, inEnd);
        return root;
    }

    public static void test01() {
        // 正常测试
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        TreeNode ret = buildTree(pre, in);
        print(ret);
        // 异常测试
        int[] pre1={};
        int[] in1={};
        TreeNode ret1 = buildTree(pre1, in1);
        print(ret1);

        int[] pre2={1};
        int[] in2={};
        TreeNode ret2 = buildTree(pre2, in2);
        print(ret2);
    }

    public static void print(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        print(root.left);
        print(root.right);
    }

    public static void main(String[] args) {
        test01();
    }
}
