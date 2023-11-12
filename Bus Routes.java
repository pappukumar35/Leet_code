class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // Edge Case
        if (source == target)
            return 0;

        // Garph Building
        // Key:- the Station
        // Value:- Buses can be taken in this stations
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                map.putIfAbsent(stop, new ArrayList<>());
                map.get(stop).add(i);
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        Set<Integer> vis = new HashSet<>();

        q.offer(source);
        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                ArrayList<Integer> buses = map.get(q.poll());
                for (int bus : buses) {
                    if (vis.contains(bus)) {
                        continue;
                    }

                    vis.add(bus);
                    for (int stop : routes[bus]) {
                        if (stop == target)
                            return count + 1;
                        q.offer(stop);
                    }
                }
            }
            count++;
        }

        return -1;
    }
}