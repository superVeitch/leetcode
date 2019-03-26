import com.leetcode.algorithms.*;
import com.leetcode.algorithms.listNode.ListNode;
import com.leetcode.algorithms.listNode.MergeTwoLists;
import com.leetcode.algorithms.listNode.ReverseList;
import com.leetcode.algorithms.rangeSumBST.*;
import com.leetcode.target.SingleNumber;
import org.junit.Test;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class ExecutorRunTest {
//    @Test
//    public void run(){
//        TreeNode treeNode = new TreeNode(1);
//        treeNode.right = new TreeNode(5);
//        treeNode.right.left = new TreeNode(3);
//        GetMinimumDifference g = new GetMinimumDifference();
//        int i = g.getMinimumDifference(treeNode);
//        System.out.println(i);
//    }


    @Test
    public void twoSum(){
        TwoSum t = new TwoSum();
        int[] i = new int[]{1,2,3,4,4,9,56,90};
        int[] j = t.twoSum(i, 8);
        for (int m = 0; m < j.length; m++) {
            System.out.println(j[m]);
        }

    }

    @Test
    public void isSameTree(){
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        IsSameTree i = new IsSameTree();
        System.out.println(i.isSameTree(treeNode, treeNode));
    }

    @Test
    public void minDepth(){
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
//        treeNode.right = new TreeNode(20);
//        treeNode.left.left = new TreeNode(15);
//        treeNode.left.right = new TreeNode(7);
        MinDepth i = new MinDepth();
        System.out.println(i.minDepth(treeNode));
    }

    @Test
    public void test(){
        Map<String, String> map = new HashMap<>(0);
        Map<String, String> map1 = Collections.singletonMap("1", "3");
        map1.put("1", "3");
        map = map1;
        map.put("test", "1");


        System.out.println(map);
    }


    @Test
    public void searchInsert(){
        SearchInsert si = new SearchInsert();
        int[] i = new int[]{1,3,5,6};
        System.out.println(si.searchInsert(i, 2));
    }

    @Test
    public void plusOne(){
        PlusOne po = new PlusOne();
        int[] i = new int[]{9, 9, 9};
        int[] j = po.plusOne(i);
        for (int k = 0; k < j.length; k++) {
            System.out.println(j[k]);
        }
    }

    @Test
    public void merge(){
        Merge m = new Merge();
        int[] num1 = new int[]{-1,3,0,0,0,0,0};
        int[] num2 = new int[]{0,0,1,2,3};
        m.merge2(num1, 2, num2, 5);
    }
    @Test
    public void singleNumberTest() {
//        SingleNumber sn = new SingleNumber();
//        int[] i = new int[]{2,2,1};
//        int j = sn.singleNumber(i);
        BigDecimal bg = new BigDecimal(0.3127).setScale(4, RoundingMode.HALF_UP);
        System.out.println(bg.multiply(new BigDecimal(100)));
        System.out.println(bg.multiply(new BigDecimal(100)).doubleValue());
        System.out.println(bg.multiply(new BigDecimal(1)).doubleValue());
        System.out.println((bg.doubleValue())*100);
        Double d = new Double(0.3127);
        System.out.println(d*100d);
    }

    @Test
    public void mergeTwoLists(){
//        List<Integer> a = Arrays.asList(-10,-10,-9,-4,1,6,6);
//        ListNode l1 = new ListNode(0);
//        ListNode ac = l1;
//        for (int i = 0; i < a.size(); i++) {
//            ac.next = new ListNode(a.get(i));
//            ac = ac.next;
//        }
//        ListNode l2 = new ListNode(-7);
//        MergeTwoLists mt = new MergeTwoLists();
//        ListNode l = mt.mergeTwoLists2(l1.next, l2);

        Date d = new Date();
        System.out.println(d);
    }

    @Test
    public void minStack(){
//        MinStack ms = new MinStack();
//        ms.push(-2);
//        ms.push(0);
//        ms.push(-3);
//
//        System.out.println(ms.getMin());
//        ms.pop();
//        ms.top();
//        System.out.println(ms.getMin());
        int i = 1000;
        int j = 1000;
        System.out.println(j == i);
    }

    @Test
    public void LRUCacheTest(){
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }

    @Test
    public void detectCycle(){
        List<Integer> a = Arrays.asList(3,2,0,-4);
        com.leetcode.algorithms.ListNode l1 = new com.leetcode.algorithms.ListNode(0);
        com.leetcode.algorithms.ListNode ac = l1;
        for (int i = 0; i < a.size(); i++) {
            ac.next = new com.leetcode.algorithms.ListNode(a.get(i));
            ac = ac.next;
        }
        DetectCycle dc = new DetectCycle();
        dc.detectCycle(l1.next);
    }

    @Test
    public void reverseListTest(){
        ListNode lc = new ListNode(1);
        lc.next = new ListNode(2);
        lc.next.next = new ListNode(3);
        ReverseList rs = new ReverseList();
        ListNode l = rs.reverseList1(lc);
    }

    @Test
    public void reverseStringTest() {
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        ReverseString rs = new ReverseString();
        rs.reverseString1(s);
        for (int i = 0, l = s.length; i < l; i++) {
            System.out.println(s[i]);
        }
    }

    @Test
    public void containsDuplicate(){
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1,2,3,4}));
    }

    @Test
    public void maxProfit() {
        MaxProfit mp = new MaxProfit();
//        System.out.println(mp.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(mp.maxProfitV2(new int[]{7,1,5,3,6,4}));
    }
}
