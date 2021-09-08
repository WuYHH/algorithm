package Tree;

/**
 * @author wuyuhan
 * @date 2021/9/8 下午4:12
 */
public class BuildTree_InPostOrder_leetcode_106 {


    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;
        return build(inorder, 0, inorder.length-1,
                     postorder, 0, postorder.length-1);
    }
    public static TreeNode build(int[] inorder, int inStart, int inEnd,
                                 int[] postorder, int postStart, int postEnd) {
        //base case
        if (postStart > postEnd) return null;
        int rootVal = postorder[postEnd];
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (rootVal == inorder[i]) {
                index = i;
                break;
            }
        }

        TreeNode node = new TreeNode(rootVal);
        int leftSize = index - inStart;
        // postEnd = postStart + leftSize - 1，
        // 因为当左子树只有一个结点时，postStart = postEnd = 0;
        node.left = build(inorder, inStart, index - 1,
                          postorder, postStart, postStart + leftSize - 1);
        node.right = build(inorder, index + 1, inEnd,
                          postorder, postStart + leftSize, postEnd - 1);
        return node;
    }
    public static void test01() {
        // 正常测试

        int[] in = {9, 3, 15, 20, 7};
        int[] post = {9, 3, 15, 20, 7};
        TreeNode ret = buildTree(in, post);
        print(ret);
        // 异常测试
        int[] in1={};
        int[] pre1={};
        TreeNode ret1 = buildTree(in1, pre1);
        print(ret1);

        int[] in2={};
        int[] pre2={1};
        TreeNode ret2 = buildTree(in2,pre2);
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
