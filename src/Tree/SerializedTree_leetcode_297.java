package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wuyuhan
 * @date 2021/9/9 下午2:36
 * notes:
 *  1. 根据字符串反向序列化一棵二叉树
 *  （1）递归：前序、后序
 *  （2）迭代：层级（正向/反向序列化均为层次遍历）
 */
public class SerializedTree_leetcode_297 {

    /**
     * 把一棵二叉树序列化为字符串
     * @param root
     * @return
     */
    public static String serialized(TreeNode root) {
        if (root == null) return null;
        StringBuilder stringBuilder = new StringBuilder();
        traverse(root, stringBuilder);
        // 转为字符串[2,1,null,6,null,null,3,null,null,],注意[null,]中的","的处理
        return stringBuilder.toString();
    }

    /**
     * 前序+中序+后序+层次遍历
     * @param root
     * @param sb
     * @return
     */
    public static void traverse(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append((String) null).append(",");
            return;
        }
        // 前序
        sb.append(root.val).append(",");
        traverse(root.left, sb);
//        中序
//        sb.append(root.val).append(",");
        traverse(root.right, sb);
//        后序
//        sb.append(root.val).append(",");
    }

    /**
     * 递归后序 序列化,末尾不带“,”(只能是后续)
     * 函数功能：build为以root为根结点，创建序列化字符串并返回
     *
     * @param root
     * @return
     */
    public static String build(TreeNode root) {
        // base case
        if (root == null) return "#";
        String left = build(root.left);
        String right = build(root.right);
        String sub = left + "," + right + "," + root.val;
        return sub;
    }
    /**
     * 将层序遍历模板（不记录null值）修改为 记录null值
     * @param root
     */
    public static String level_serialized(TreeNode root) {
//        if(root == null)
        StringBuilder sb = new StringBuilder();
        if (root == null) return "";

        // 初始化队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 类似于add，但比add方法更可取
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 出队
            TreeNode curr = queue.poll();

            /* 层级遍历代码位置*/
            if (curr == null) {
                // null的处理逻辑
                sb.append("#").append(",");
                continue;
            }

            sb.append(curr.val).append(",");

            queue.offer(curr.left);
            queue.offer(curr.right);

        }
        return sb.toString();
    }

    /**
     * 层级遍历反序列化
     * @param data
     * @return
     */
    public static TreeNode level_Deserialized(String data) {
        if (data.isEmpty()) return null;
        String[] nodes = data.split(",");
        // 构建第一个根结点
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        // 存放父节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 没有 i++ ，
        for (int i = 1; i < nodes.length; ) {
            TreeNode node = queue.poll();

            // 父节点对应的左子节点的值：子节点一定有两个值
            //
            String left = nodes[i++]; // core
            if (!left.equals("#")) {
                node.left = new TreeNode(Integer.parseInt(left));
                queue.offer(node.left);
            } else {
                node.left = null;
            }

            String right = nodes[i++];
            if (!right.equals("#")) {
                node.right = new TreeNode(Integer.parseInt(right));
                queue.offer(node.right);
            } else {
                node.right = null;
            }
        }
        return root;
    }
    /**
     * 把字符串序列化为二叉树：
     *  1.通过前、后、层序遍历一种遍历就可复原一棵二叉树
     *  2.前中后的两种组合
     * @param data
     * @return
     */
    public TreeNode deserialized(String data) {
        // 将字符串转为链表
        LinkedList<String> nodes = new LinkedList<>();
        for(String s : data.split(",")) {
            nodes.add(s);
        }
        return deserialized(nodes);
    }

    /**
     * 根据list递归构建二叉树，并返回根结点
     * 无论是先序还是后序，必须先找到根结点！左右子树的遍历顺序有变化！
     * @param nodes
     * @return
     */
    public TreeNode deserialized(LinkedList<String> nodes) {
        // base case
        if (nodes.isEmpty()) return null;

        /**
         * 先序遍历：最左侧即为根结点
         */
        String left = nodes.removeFirst();
        // equals来比较字符串
        if (left.equals(null)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(left));

        /*
        * 生成顺序：根->左子树->右子树
        * */
        root.left = deserialized(nodes);// nodes已经poll了一个结点，已经变化
        root.right = deserialized(nodes);

        /*
        * 后序遍历：最右侧即为根结点
        * */
//        String left = nodes.removeLast();
//        // equals来比较字符串
//        if (left.equals(null)) return null;
//        TreeNode root = new TreeNode(Integer.parseInt(left));
        /*
        * 生成顺序：根->右子树->左子树
        * */
//        root.right = deserialized(nodes);
//        root.left = deserialized(nodes);// nodes已经poll了一个结点，已经变化

        return root;
    }

    public static void test() {
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        node2.left = node1;
        node2.right = node3;
        node1.right = node6;
//        serialized(node2);
        String res = build(node2);
        System.out.println(res);
    }

    public static void main(String[] args) {
        test();
    }
}
