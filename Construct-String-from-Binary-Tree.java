class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }

        // Step 1: Start with an empty result string
        StringBuilder result = new StringBuilder();

        // Step 2: Perform preorder traversal
        preorderTraversal(root, result);

        // Step 3: Return the final result string
        return result.toString();
    }

    private void preorderTraversal(TreeNode node, StringBuilder result) {
        if (node == null) {
            return;
        }

        // Step 4: Append the current node's value to the result
        result.append(node.val);

        // Step 5: Check if the current node has a left child or a right child
        if (node.left != null || node.right != null) {

            // Step 6: If there is a left child, add empty parentheses for it
            result.append("(");
            preorderTraversal(node.left, result);
            result.append(")");
        }

        // Step 7: If there is a right child, process it similarly
        if (node.right != null) {
            result.append("(");
            preorderTraversal(node.right, result);
            result.append(")");
        }

        // Step 8: The recursion will handle all the child nodes
    }
}