class Graph {
    List<List<int[]>> adj = new ArrayList<>();
    int n;

    public Graph(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        this.n = n;
        for (var edge : edges) {
            adj.get(edge[0]).add(new int[] { edge[1], edge[2] });
        }
    }

    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new int[] { edge[1], edge[2] });
    }

    public int shortestPath(int node1, int node2) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[node1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { node1, 0 });
        while (!pq.isEmpty()) {
            int temp = pq.poll()[0];

            for (int[] i : adj.get(temp)) {
                int x = i[0];
                int y = i[1];

                if (distance[x] > distance[temp] + y) {
                    distance[x] = distance[temp] + y;
                    pq.add(new int[] { x, distance[x] });
                }
            }
        }

        if (distance[node2] == Integer.MAX_VALUE) {
            return -1;
        }
        return distance[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */