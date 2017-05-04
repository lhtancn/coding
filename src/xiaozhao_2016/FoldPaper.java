package xiaozhao_2016;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lhtan on 5/4/2017.
 */

/**
 * 请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展 开。此时有1条折痕，突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕 ；突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。如果每次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。
 给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
 测试样例：
 1
 返回：["down"]
 */
public class FoldPaper {
    public String[] foldPaper(int n) {
        // write code here
        if(n < 1) {
            return null;
        }
        TreeNode pHead = new TreeNode("down");
        createTree(pHead, 1, n);

        List<String> list = new ArrayList<>();
        midThrough(pHead, list);
        return list.toArray(new String[list.size()]);
    }

    private void midThrough(TreeNode treeNode, List<String> list) {
        if(treeNode.left != null) {
            midThrough(treeNode.left, list);
        }
        list.add(treeNode.val);

        if(treeNode.right != null){
            midThrough(treeNode.right, list);
        }
    }

    private void createTree(TreeNode root, int depth, int n) {
        if(depth == n) {
            root.left = null;
            root.right = null;
            return;
        }
        root.left = new TreeNode("down");
        root.right = new TreeNode("up");
        createTree(root.left, depth + 1, n);
        createTree(root.right, depth + 1, n);
    }
}


 class TreeNode {           //方法和变量都可包级私有
    String val;
    TreeNode left;
    TreeNode right;
    TreeNode(String val){
        this.val = val;
    }
}
