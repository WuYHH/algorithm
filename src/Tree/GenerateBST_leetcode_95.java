package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wuyuhan
 * @date 2021/9/14 下午6:16
 */
public class GenerateBST_leetcode_95 {


    /**
     * 根据n构建所有可能的BST
     * @param n
     * @return
     */
    static List<TreeNode> generateBST(int n) {
        if (n == 0) return new LinkedList<>();
        return generateBST(1, n);
    }

    /**
     * 辅助函数，增加额外的变量信息，一般涉及到数组就会有[low,high]
     * @param low
     * @param high
     * @return
     */
    static List<TreeNode> generateBST(int low, int high) {
        List<TreeNode> res = new LinkedList<>();
        // base case
        if (low > high) {
            res.add(null);
            return res;
        }
        // root:
        // 1.穷尽所有的root节点
        for (int i = low; i <= high; i++) {
            // 2.生成所有的子树结点
            List<TreeNode> leftNode = generateBST(low, i - 1);
            List<TreeNode> rightNode = generateBST(i + 1, high);
            TreeNode root = new TreeNode(i);
            // 3.root穷尽所有子树结点
            for (TreeNode lnode : leftNode) {
                for (TreeNode rnode : rightNode) {
                    root.left = lnode;
                    root.right = rnode;
                    res.add(root);
                }
            }
        }
        return res;
    }


    static void test() {
        // valid
        int n = 3;
        // invalid
        int n1 = 0;
//        List<TreeNode> treeNodes = generateBST(n);
        List<TreeNode> treeNodes = generateBST(n1);
        for (TreeNode node : treeNodes) {
            print(node);
            System.out.println("-------------------------");
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    static void print(TreeNode root) {
        if(root == null) return;
        print(root.left);
        System.out.println(root.val);
        print(root.right);
    }

    public static void main(String[] args) {
        test();
    }
}
