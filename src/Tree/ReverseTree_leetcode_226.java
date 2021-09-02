package Tree;

/**
 * @author wuyuhan
 * @date 2021/9/1 下午4:56
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {this.val = val;}
}

class Node {
    int val;
    Node left;
    Node right;
    Node next;
    Node(int val) {this.val = val;}
}
public class ReverseTree_leetcode_226 {
    public static void main(String[] args) {
        test01();
    }

    /**
     * 以root为根的二叉树拉成链表
     * @param root
     */
    void flatten(TreeNode root) {
        if (root == null) return;
        // 将左右子树拉直
        flatten(root.left);
        flatten(root.right);
        // 拉直后的处理
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 变成单支二叉树
        root.left = null;
        root.right = left;

        // 遍历，将右子树接到现在的右子树（原左子树）上
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    /**
     * 翻转二叉树
     * @param head
     * @return
     */
    public static TreeNode reverseTree(TreeNode head) {
        // base case
        if (head == null) return null;

        // 前序遍历
        TreeNode temp = head.left;
        head.left = head.right;
        head.right = temp;

        reverseTree(head.left);
        reverseTree(head.right);
        return head;
    }
    public static Node connect(Node root) {
        if (root == null) return null;
        connectTwoNode(root.left, root.right);
        return root;
    }

    public static void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) return;
        // 将传入的两个节点连接
        node1.next = node2;
        // 连接同一个父节点的
        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);
        // 连接非同一个父节点的
        connectTwoNode(node1.right, node2.left);
    }
    public static void test01() {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        print(node1);
        TreeNode retNode = reverseTree(node1);
        System.out.println("-------------------------------");
        print(retNode);
    }
    // 前序遍历
    public static void print(TreeNode head) {
        if (head == null) return;
        System.out.println(head.val);
        print(head.left);
        print(head.right);
    }
}
