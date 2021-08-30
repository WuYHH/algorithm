package ListNode;

import java.util.List;

/**
 * @author wuyuhan
 * @date 2021/8/29 下午10:02
 */

class ListNode {
    int var;
    ListNode next;
    ListNode(int var) {this.var = var;}
}

public class ReverseListNode_leetcode_92 {
    public static void main(String[] args) {
        test01();
    }

    public ListNode reverseAll(ListNode head) {
        if (head.next == null)
            return head;
        ListNode last = reverseAll(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    ListNode successor = null;
    public ListNode reverseTopN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseTopN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    /**
     * @param head
     * @param left
     * @param right
     * 递归方法, 时间复杂度 O(N), 空间复杂度 O(N)
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            // 不是head.next or right.next !
            return reverseTopN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    /**
     * @param head
     * @param left
     * @param right
     * 非递归方法:头插法。时间复杂度 O(N), 空间复杂度 O(1)
     * @return
     */
    public ListNode revserBetween2(ListNode head, int left, int right) {
        if(head == null) return null;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++)
            pre = pre.next;

        ListNode curr = pre.next;
        ListNode next;
        // 点睛之笔
        for (int i = 0; i < right - left; i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
    public static void test01() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        print(node1);
        ReverseListNode_leetcode_92 reverseListNode_92 = new ReverseListNode_leetcode_92();
        ListNode ret = reverseListNode_92.reverseBetween(node1, 2, 4);
        print(ret);
        // 单结点list
//        ListNode singleNode = new ListNode(-1);

    }
    public static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.var);
            listNode = listNode.next;
        }
        System.out.println();
    }
}
