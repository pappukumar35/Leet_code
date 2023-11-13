import java.util.*;

public class Solution {
    // Function to find the minimum number of buses needed to reach the target from
    // the source.
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // If source and target are the same, no buses are needed.
        if (source == target) {
            return 0;
        }

        // Create an adjacency list to represent stops and the routes that include each
        // stop.
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int route = 0; route < routes.length; route++) {
            for (int stop : routes[route]) {
                adjList.computeIfAbsent(stop, k -> new ArrayList<>()).add(route);
            }
        }

        // Initialize a queue for BFS and a set to keep track of visited routes.
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();

        // Insert all the routes in the queue that have the source stop.
        for (int route : adjList.getOrDefault(source, new ArrayList<>())) {
            q.add(route);
            vis.add(route);
        }

        int busCount = 1; // Initialize the bus count.

        // Perform BFS to find the minimum number of buses needed.
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int route = q.poll();

                // Iterate over the stops in the current route.
                for (int stop : routes[route]) {
                    // Return the current count if the target is found.
                    if (stop == target) {
                        return busCount;
                    }

                    // Iterate over the next possible routes from the current stop.
                    for (int nextRoute : adjList.getOrDefault(stop, new ArrayList<>())) {
                        if (!vis.contains(nextRoute)) {
                            vis.add(nextRoute);
                            q.add(nextRoute);
                        }
                    }
                }
            }
            busCount++;
        }

        // If no route is found, return -1.
        return -1;
    }
}
