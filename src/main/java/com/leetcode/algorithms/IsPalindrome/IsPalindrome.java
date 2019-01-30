package com.leetcode.algorithms.IsPalindrome;


import java.util.LinkedList;
import java.util.Objects;

public class IsPalindrome {
    public static boolean isPalindrome(ListNode head) {
        if (Objects.isNull(head)){
            return true;
        }
        LinkedList<Integer> whole = new LinkedList<>();
        while (true) {
            whole.add(head.val);
            if (Objects.isNull(head.next)) {
                break;
            }
            head = head.next;
        }

        for (int i = 0; i < whole.size()/2; i++) {
            if (!whole.get(i).equals(whole.get(whole.size()-1-i))){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(node));

    }
}
