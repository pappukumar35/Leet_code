class Solution13 {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        queue.offer(root);
        if (root == null)
            return ans;
        while (!queue.isEmpty()) {
            int level = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < level; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                max = Math.max(max, temp.val);
            }
            ans.add(max);
        }
        return ans;
    }
}