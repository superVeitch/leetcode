package com.leetcode.algorithms.addTwoNumbers;


public class AddTwoNumbers {

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = null;
        int i = 0;
        if (l1.val+l2.val > 9) {
            l = new ListNode(l1.val+l2.val - 10);
            i = i+1;
        } else {
            l = new ListNode(l1.val+l2.val);
        }
        if (l1.next != null || l2.next != null) {
            test(l, l1.next, l2.next, i);

        }else {
            if (i == 1){
                l.next = new ListNode(i);
            }
        }
        return l;
    }

    private static void test(ListNode l, ListNode l1, ListNode l2, int i) {
        int sum = 0;
        if (i == 1) {
            sum = sum + 1;
        }
        ListNode l3 = null;
        ListNode l4 = null;
        if (l1 != null){
            sum = l1.val+sum;
            if (l1.next != null) {
                l3 = l1.next;
            }
        }
        if (l2 != null){
            sum = l2.val+sum;
            if (l2.next != null){
                l4=l2.next;
            }
        }
        if (sum > 9) {
            l.next = new ListNode(sum - 10);
            i = 1;
        } else {
            l.next = new ListNode(sum);
            i = 0;
        }

        if (l3 != null || l4 != null) {
            test(l.next, l3, l4, i);
        } else {
            if (i ==1) {
                l.next.next = new ListNode(1);
            }
        }
    }

}
