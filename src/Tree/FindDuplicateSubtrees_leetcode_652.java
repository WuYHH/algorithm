package Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wuyuhan
 * @date 2021/9/9 下午4:27
 */
public class FindDuplicateSubtrees_leetcode_652 {

    List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return null;
        // 1. 明确遍历顺序：当前结点树的形状（序列化）
        // 2. 当前结点子树的形状
        // 3. 比较形状
        build(root);
        return res;
    }

    /**
     * 1.build方法功能：以root为根结点，序列化一棵树，并返回序列化后的字符串
     * 2.构建HashSet记录所有子树，判断是否和子串重复
     * @param root
     * @return
     */
    // 记录所有子树
    // HashSet<String> memo = new HashSet<>();
    HashMap<String, Integer> memo = new HashMap<>();

    // 记录重复的子树根结点
    LinkedList<TreeNode> res = new LinkedList<>();

    String build(TreeNode root) {
        // base case
        if (root == null) return "#";
        // 序列化后序遍历
        String left = build(root.left);
        String right = build(root.right);
        String subTree = left + "," + right + "," + root.val;
        // 返回映射的次数
        int freq = memo.getOrDefault(subTree, 0);
        // 避免res多次重复
        if (freq == 1) {
            res.add(root);
        }
        // 子树出现的次数+1
        memo.put(subTree, freq+1);
        return subTree;
        /*if (memo.contains(subTree)) {
            // 重复加入结果列表, 多个重复就会有多个res
            res.add(root);
        } else {
            // 不重复
            memo.add(subTree);
        }*/

    }

    public void test() {
        // valid
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(4);

        TreeNode singleNode = new TreeNode(9999);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;
        node5.left = node7;

        List res = findDuplicateSubtrees(node1);
        for (int i = 0; i < res.size(); i++) {
            System.out.println((res.get(i)));
        }
    }
    public static void main(String[] args) {
        FindDuplicateSubtrees_leetcode_652 a = new FindDuplicateSubtrees_leetcode_652();
        a.test();
    }
}
