class Solution {
    public int[][] imageSmoother(int[][] img) {
        int rows = img.length;
        int cols = img[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                int totalSum = 0;
                int count = 0;

                for (int x = Math.max(0, i-1); x < Math.min(rows, i+2); ++x) {
                    for (int y = Math.max(0, j-1); y < Math.min(cols, j+2); ++y) {
                        totalSum += img[x][y];
                        count += 1;
                    }
                }

                result[i][j] = totalSum / count;
            }
        }

        return result;
    }
}