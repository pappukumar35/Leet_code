import java.util.*;

public class Solution1 {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        // Create a list of Flower objects to keep track of bloom times
        List<Flower> flowerList = new ArrayList<>();
        for (int i = 0; i < flowers.length; i++) {
            flowerList.add(new Flower(flowers[i][0], flowers[i][1]));
        }

        // Sort the list of flowers based on their bloom times
        Collections.sort(flowerList, (a, b) -> a.bloomTime - b.bloomTime);

        int[] result = new int[people.length];
        int bloomIndex = 0; // Index to track the current flower in bloom

        for (int i = 0; i < people.length; i++) {
            int personTime = people[i];

            // Count flowers in full bloom when the person arrives
            while (bloomIndex < flowerList.size() && flowerList.get(bloomIndex).bloomTime <= personTime) {
                bloomIndex++;
            }
            result[i] = bloomIndex;
        }

        return result;
    }

    private class Flower {
        int bloomTime;
        int wiltTime;

        public Flower(int bloomTime, int wiltTime) {
            this.bloomTime = bloomTime;
            this.wiltTime = wiltTime;
        }
    }
}
