import java.util.LinkedList;
import java.util.Queue;

public class LC100_isSameTree {
    public static boolean isSameTree1(TreeNode p, TreeNode q) { //递归方法
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null && p.val == q.val) {
            return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
        } else {
            return false;
        }
    }

    public static boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            return true;
        }
        Queue<TreeNode> Qp = new LinkedList<>();
        Queue<TreeNode> Qq = new LinkedList<>();
        Qp.add(p);
        Qq.add(q);

        while(Qp.size() !=0 && Qq.size() != 0){
            TreeNode temp_p = Qp.poll();
            TreeNode temp_q = Qq.poll();

            if(temp_p.val != temp_q.val)
                return false;

            if(temp_p.left != null && temp_q.left != null){ //都有节点
                Qp.add(temp_p.left);
                Qq.add(temp_q.left);
            }else if(temp_p.left == null && temp_q.left == null){
                //都没节点
            }else{
                return false;  //一个有一个没
            }

            if(temp_p.right != null && temp_q.right != null){
                Qp.add(temp_p.right);
                Qq.add(temp_q.right);
            }else if(temp_p.right == null && temp_q.right == null){

            }else {
                return false;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println(isSameTree2(p,q));
    }

}
