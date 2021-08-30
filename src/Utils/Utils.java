package Utils;

/**
 * @author wuyuhan
 * @date 2021/8/29 下午9:57
 */
public class Utils {
    public static ListNode getListNode(int val) {
        return new ListNode(val);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {this.val = val;}
}