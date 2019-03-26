package com.leetcode.algorithms.listNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 我们遍历所有结点并在哈希表中存储每个结点的引用（或内存地址）。如果当前结点为空结点 null（即已检测到链表尾部的下一个结点），那么我们已经遍历完整个链表，并且该链表不是环形链表。如果当前结点的引用已经存在于哈希表中，那么返回 true（即该链表为环形链表）。
 *
 * 复杂度分析
 *
 * 时间复杂度：O(n)O(n)， 对于含有 nn 个元素的链表，我们访问每个元素最多一次。添加一个结点到哈希表中只需要花费 O(1)O(1) 的时间。
 *
 * 空间复杂度：O(n)O(n)， 空间取决于添加到哈希表中的元素数目，最多可以添加 nn 个元素。
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> listNodes = new HashSet<>();
        while (head != null) {
            if (listNodes.contains(head)){
                return true;
            } else {
                listNodes.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 如果环形，快指针已经回赶上慢指针，
     * @param head
     * @return
     */
    public boolean hasCycle3(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
