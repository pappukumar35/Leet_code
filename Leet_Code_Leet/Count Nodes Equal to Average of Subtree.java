class Solution {
    private int res = 0;

    public int averageOfSubtree(TreeNode root) {
        postorder(root);
        return res;
    }

    private int[] postorder(TreeNode node) {
        if (node == null) {
            return new int[] { 0, 0 }; // sum, number of nodes
        }

        int[] left = postorder(node.left);
        int[] right = postorder(node.right);

        int totalSum = left[0] + right[0] + node.val;
        int totalCount = 1 + left[1] + right[1];
        res += (node.val == totalSum / totalCount ? 1 : 0);

        return new int[] { totalSum, totalCount };
    }
}