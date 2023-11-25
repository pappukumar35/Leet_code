public class Restore
the Array
From Adjacent Pairs
{

    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length;
        int m = adjacentPairs[0].length;
        int ans[] = new int[n + 1];
        HashSet<Integer> set = new HashSet<>();// stores all the unique elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                set.add(adjacentPairs[i][j]);
            }
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();// stores adjacent elements for each element
        for (int k : set) {
            ArrayList<Integer> temp = new ArrayList<>();
            map.put(k, temp);
        }
        for (int i = 0; i < n; i++) {
            map.get(adjacentPairs[i][0]).add(adjacentPairs[i][1]);
            map.get(adjacentPairs[i][1]).add(adjacentPairs[i][0]);
        }
        // Reconstructing the array
        int start = 0;
        for (int key : map.keySet()) {
            if (map.get(key).size() == 1) {
                start = key;
                break;
            }
        }
        ans[0] = start;
        ans[1] = map.get(start).get(0);

        for (int i = 2; i < n + 1; i++) {
            ArrayList<Integer> neighbours = map.get(ans[i - 1]);
            ans[i] = (ans[i - 2] == neighbours.get(0) ? neighbours.get(1) : neighbours.get(0));
        }
        return ans;
    }
}}
