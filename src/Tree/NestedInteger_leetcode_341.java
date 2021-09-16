package Tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wuyuhan
 * @date 2021/9/16 上午9:00
 * notes:
 *  这tm就是一棵N叉树呀
 */

class NestedInteger {
    private Integer val;
    private List<NestedInteger> list;

    public NestedInteger(Integer val) {
        this.val = val;
        this.list = null;
    }

    public NestedInteger(List<NestedInteger> list) {
        this.list = list;
        this.val = val;
    }

    public boolean isInteger() {
        return val != null;
    }

    public Integer getInteger() {
        return this.val;
    }

    public List<NestedInteger> getList() {
        return this.list;
    }
}

public class NestedInteger_leetcode_341 implements Iterator<Integer> {

    private Iterator<Integer> it;

    public NestedInteger_leetcode_341(List<NestedInteger> nestedList) {
            // 存放将nestedList打平的结果
        List<Integer> result = new LinkedList<>();
        for (NestedInteger node : nestedList) {
            // 以每个节点为根遍历
            traverse(node, result);
        }
        this.it = result.iterator();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public Integer next() {
        return it.next();
    }

    /**
     * N叉树遍历
     *  base case:叶子节点的处理
     * @param root
     * @param result
     */
    private void traverse(NestedInteger root, List<Integer> result) {
        // base case
        if (root.isInteger()) {
            // 叶子节点
            result.add(root.getInteger());
            return;
        }
        for (NestedInteger child : root.getList()) {
            traverse(child, result);
        }
    }

    public static void test() {

    }
    public static void main(String[] args) {
        test();
    }

}
