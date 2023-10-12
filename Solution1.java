class Solution1 {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] sortedPeople = Arrays.copyOf(people, people.length);
        Arrays.sort(sortedPeople);

        Arrays.sort(flowers, (a, b) -> Arrays.compare(a, b));
        Map<Integer, Integer> dic = new HashMap();
        PriorityQueue<Integer> heap = new PriorityQueue();

        int i = 0;
        for (int person : sortedPeople) {
            while (i < flowers.length && flowers[i][0] <= person) {
                heap.add(flowers[i][1]);
                i++;
            }

            while (!heap.isEmpty() && heap.peek() < person) {
                heap.remove();
            }

            dic.put(person, heap.size());
        }

        int[] ans = new int[people.length];
        for (int j = 0; j < people.length; j++) {
            ans[j] = dic.get(people[j]);
        }

        return ans;
    }
}
