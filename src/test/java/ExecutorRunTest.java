import com.leetcode.algorithms.TwoSum;
import com.leetcode.algorithms.rangeSumBST.GetMinimumDifference;
import com.leetcode.algorithms.rangeSumBST.IsSameTree;
import com.leetcode.algorithms.rangeSumBST.TreeNode;
import org.junit.Test;

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
}
