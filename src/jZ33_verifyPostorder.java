public class jZ33_verifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length < 2)
            return true;
        return verify(postorder, 0, postorder.length - 1);
    }

    public boolean verify(int[] postorder, int start, int end) {
        if (start >= end)
            return true;
        // 找到当前的根节点，左边的应该比他小，右边的应该比他大
        int root = postorder[end];
        // 通过根节点的值找到第一个右子树节点
        int bigger = start;
        while (bigger < end) {
            if (postorder[bigger] > postorder[end])
                break;
            bigger++;
        }
        for (int i = bigger; i < end; i++) {
            if (postorder[i] < root)
                return false;
        }

        return verify(postorder, start, bigger - 1) && verify(postorder, bigger, end - 1);
    }
}
