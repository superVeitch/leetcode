package com.leetcode.algorithms.listNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {

    // 单向链表只能操作next赋值
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        }
        if (l1 == null) {
            return l2;
        }
        ListNode start = new ListNode(0);
        ListNode curr = start;
        while (l2 != null) {
            if (l1.val > l2.val) {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
                if (l2 == null) {
                    curr.next = new ListNode(l1.val);
                }
            } else {
                curr.next = new ListNode(l1.val);
                curr = curr.next;
                curr.next = l2;
                break;
            }
        }
        return mergeTwoLists2(l1.next, start.next);
//        return start.next;
    }
}
