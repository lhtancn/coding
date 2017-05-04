package xiaozhao_2016;

import java.util.List;

/**
 * Created by lhtan on 5/4/2017.
 */

/**
 * 对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
 给定一个链表的头指针A，请返回一个bool值，代表其是否为回文结构。保证链表长度小于等于900。
 测试样例：
 1->2->2->1
 返回：true
 */

public class PalindromeList {
    public boolean chkPalindrome(ListNode A) {
        // write code here
        if(A == null) {
            return true;
        }
        ListNode midNode = getMidNode(A);
        ListNode tail = getReverse(midNode);
        ListNode former = A;
        ListNode late = tail;
        boolean tag = false;
        while(former.val == late.val) {
            if(late == midNode) {
                tag = true;
                break;
            }
            late = late.next;
            former = former.next;
        }
        return tag;
    }

    private ListNode getReverse(ListNode mid) {
        ListNode pre = mid;
        ListNode cur = pre.next;

        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private ListNode getMidNode(ListNode root) {
        ListNode slow = root;
        ListNode fast = root;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
