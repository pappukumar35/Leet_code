import java.util.Arrays;

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int diff = 0;
        for (int i = 1; i < points.length; i++) {
            diff = Math.max(diff, points[i][0] - points[i - 1][0]);
        }
        return diff;
    }
}