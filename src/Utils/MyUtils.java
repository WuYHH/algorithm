package Utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wuyuhan
 * @date 2021/8/29 下午9:57
 */
public class MyUtils {

    /**
     * 中序遍历
     * @param root
     */
    public static void print(TreeNode root) {
        if (root == null) return;
        print(root.left);
        System.out.println(root.val);
        print(root.right);
    }


    /**
     * 根据层级遍历字符串生成二叉树，方便测试
     * @param data
     * @return
     */
    public static TreeNode getTree(String data) {
        if(data.isEmpty()) return null;
        String[] nodes = data.split(",");
        int rootVal = Integer.parseInt(nodes[0]);

        TreeNode root = new TreeNode(rootVal);
        Queue<TreeNode> queue = new LinkedList<>();
        // root入队
        queue.offer(root);

        for(int i = 1; i < nodes.length; ) {
            // 列表中存的是父节点
            TreeNode parent = queue.poll();
            String left = nodes[i++];
            if (!left.equals("null")) {
                parent.left = new TreeNode(Integer.parseInt(left));
                queue.offer(parent.left);
            } else {
                parent.left = null;
            }

            String right = nodes[i++];
            if (!right.equals("null")) {
                parent.right = new TreeNode(Integer.parseInt(right));
                queue.offer(parent.right);
            } else {
                parent.right = null;
            }
        }
        return root;
    }

    /**
     * 根据数组生成一条链表
     * @param val
     * @return
     */
    public static ListNode getList(int[] val) {
        ListNode head = null;
        for (int i = 0; i < val.length; i++) {
            ListNode p = new ListNode(val[i]);
            head.next = p;
        }
        return head.next;
    }
}


