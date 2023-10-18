class Solution6 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[n];

        for (int node = 0; node < n; node++) {
            int left = leftChild[node];
            int right = rightChild[node];
            if (left != -1) {
                graph.computeIfAbsent(node, k -> new ArrayList<>()).add(left);
                inDegree[left]++;
            }
            if (right != -1) {
                graph.computeIfAbsent(node, k -> new ArrayList<>()).add(right);
                inDegree[right]++;
            }
        }

        List<Integer> rootCandidates = new ArrayList<>();
        for (int node = 0; node < n; node++) {
            if (inDegree[node] == 0) {
                rootCandidates.add(node);
            }
        }

        if (rootCandidates.size() != 1) {
            return false;
        }
        int root = rootCandidates.get(0);

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        queue.add(root);
        seen.add(root);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (graph.containsKey(node)) {
                for (int child : graph.get(node)) {
                    if (seen.contains(child)) {
                        return false;
                    }
                    seen.add(child);
                    queue.add(child);
                }
            }
        }

        return seen.size() == n;
    }
}