package com.leetcode.algorithms.listNode;

/**
 * 编写一个程序，找到两个单链表相交的起始节点。
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class GetIntersectionNode {

    /**
     * 参考求闭环的入环节点 com.leetcode.algorithms.DetectCycle
     */
    // 先构成环，然后使用快慢指针进行判断相交的第一个点
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 将headB形成环
        ListNode last = headB;
        while (last.next != null) {
            last = last.next;
        }
        last.next = headB;


        ListNode fast = headA;
        ListNode slow = headA;

        while (fast != null && fast.next != null) {
            // 慢指针一次走一步，快指针一次走两步
            slow = slow.next;
            fast = fast.next.next;
            // 找到相遇的节点
            if (slow == fast) {
                slow = headA;
                // 根据相遇的节点找到第一个点相同的节点
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                last.next = null;
                return fast;
            }
        }
        last.next = null;
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /**
         定义两个指针, 第一轮让两个到达末尾的节点指向另一个链表的头部, 最后如果相遇则为交点(在第一轮移动中恰好抹除了长度差)
         两个指针等于移动了相同的距离, 有交点就返回, 无交点就是各走了两条指针的长度
         **/
        if(headA == null || headB == null) {return null;}
        ListNode pA = headA, pB = headB;
        // 在这里第一轮体现在pA和pB第一次到达尾部会移向另一链表的表头, 而第二轮体现在如果pA或pB相交就返回交点, 不相交最后就是null==null
        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
