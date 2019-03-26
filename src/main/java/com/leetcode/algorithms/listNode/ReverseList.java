package com.leetcode.algorithms.listNode;

import java.util.List;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseList {

    // 递归方法
    // 链表操作的是地址
    // https://blog.csdn.net/fx677588/article/details/72357389
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next ==null) {
            return head;
        }

        ListNode ln = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return ln;
    }

    private ListNode pre = null;
    public ListNode reverseList1(ListNode head) {
        reverse(head);
        return pre;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next ==null) {
            pre = head;
            return head;
        }
        ListNode ln = reverse(head.next);
        head.next = null;
        ln.next = head;
        return head;
    }
}
