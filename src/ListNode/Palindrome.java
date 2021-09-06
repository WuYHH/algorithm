package ListNode;

/**
 * @author wuyuhan
 * @date 2021/9/6 下午6:40
 */
public class Palindrome {

    /**
     * 判读一个字符串是否是回文串
     *
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    ListNode left;

    /**
     * 判断一个链表是否是回文串，采用双指针。时间复杂度O(n),空间复杂度O(n)
     * @param right
     * @return
     */
    public  boolean traverse(ListNode right) {
        if (right == null) return true;
        boolean res = traverse(right.next);
        res = res && (left.var == right.var);
        right = right.next;
        return res;
    }



    /**
     * 判断一个链表是否是回文串，采用双指针。时间复杂度O(n),空间复杂度O(1)
     * @return
     * @param head
     */
    public static  boolean traverse1(ListNode head) {
        // 快慢指针 找到中点
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 如果fast没有指向null，链表长度为奇数。slow再进一步
        if (fast != null)
            slow = slow.next;

        ListNode left = head;
        ListNode right = reverse(slow);
        // 分别记录指针位置
        ListNode q = right;
        ListNode p;
        while (right != null) {
            if (left.var != right.var)
                return false;
            left = left.next;
            right = right.next;
        }
        // 恢复链表结构
        p = left;
        p.next = reverse(q);
//        System.out.println("----------------------");
        print(head);
        return true;
    }

    /**
     * 翻转整个链表
     *       1->2->3->null
     * null<-1<-2<-3
     * @param head
     * @return
     */
    public static ListNode reverse(ListNode head) {
        ListNode pre = null, curr = head;
        while (curr != null) {
            // 防止断链
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
    public static void main(String[] args) {
        String str = "abba";
        if(isPalindrome(str)) System.out.println("true");

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        print(node1);
        boolean res = traverse1(node1);
        if (res)
            System.out.println("true");
        else
            System.out.println("false");

//        traverse(node1);
    }
    public static void print(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.println(p.var);
            p = p.next;
        }
    }
}
