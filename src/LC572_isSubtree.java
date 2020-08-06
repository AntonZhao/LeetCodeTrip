public class LC572_isSubtree {
    /**
     * leetcode-572 另一个树的子树 【中等】
     * 该方法leetcode排名一般，但是代码优雅、美丽、好看
     * 优秀题解：
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isIdentical(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isIdentical(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.val != t.val)
            return false;
        return isIdentical(s.left, t.left) && isIdentical(s.right, t.right);
    }
}
