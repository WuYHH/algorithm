package ListNode;

/**
 * @author wuyuhan
 * @date 2021/8/31 下午1:28
 */

public class ReverseKGroup_leetcode_25 {
    public static void main(String[] args) {
        test01();
    }

    /**
     * @param head 迭代反转整个链表[a, null)
     * @return
     */
    public static ListNode reverse(ListNode head) {
        if (head == null) return null;
        // core
        ListNode pre = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    /**
     * @param a 反转[a,b)之间的链表
     * @param b
     * @return
     */
    public static ListNode reverse(ListNode a, ListNode b) {
        if (a == null) return null;
        ListNode pre = null, curr = a, next;
//        ListNode head = a;
        while(curr != b) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
//        head.next = curr;
        return pre;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len ++;
            p = p.next;
        }
        if (head == null || k > len || k < 1) return null;

        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverse(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }
    public static void test01() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        // 正常测试用例
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        // 单节点测试用例
        ListNode singleNode = new ListNode(100);
        // 空节点测试
        ListNode nullNode = null;

        print(node1);
        // 反转整个链表
//        ListNode ret1 = reverse(node1);
//        print(ret1);
//         反转[a,b)部分的链表
//        ListNode ret2 = reverse(node1, node3);
//        print(ret2);
//        // 反转 k 个 [a,b)部分的链表
//        ListNode ret3 = reverseKGroup(node1, 2);
        ListNode ret4 = reverseKGroup(singleNode, 1);
//        ListNode ret5 = reverseKGroup(nullNode, 2);
//        // 异常k
//        ListNode ret3_1 = reverseKGroup(node1, -1);
//
//        print(ret3);
        print(ret4);
//        print(ret5);
    }

    public static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.var);
            listNode = listNode.next;
        }
        System.out.println();
    }
}

