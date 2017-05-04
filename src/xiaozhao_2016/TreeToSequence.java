package xiaozhao_2016;

/**
 * Created by lhtan on 5/4/2017.
 */

/**
 * 二叉树被记录成文件的过程叫做二叉树的序列化。序列化的方法有很多，这里我们采用括号序列的方法将其序列化，所谓括号序列指的是对于一个节点生成一个括号，括号内是其子树的括号序列，其中左儿子(若存在)的括号在前，右儿子(若存在)的括号在后。对于给定的树，请设计高效的算法，将其序列化。
 给定一个树的根节点指针root，请返回一个字符串，代表其序列化后的括号序列。
 */

public class TreeToSequence {
    public String toSequence(TreeNode root) {
        // write code here
        if(root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        bracket(root, sb);
        return sb.toString();
    }
    private void bracket(TreeNode root, StringBuilder sb) {
        sb.append("(");
        if(root.left != null) {
            bracket(root.left, sb);
        }
        if(root.right != null) {
            bracket(root.right, sb);
        }
        sb.append(")");
    }
}
