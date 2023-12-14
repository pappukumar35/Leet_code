class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] rowOnes = new int[grid.length];
        int[] colOnes = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                rowOnes[i] += grid[i][j];
                colOnes[j] += grid[i][j];
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = 2 * (rowOnes[i] + colOnes[j]) - grid.length - grid[0].length;
            }
        }

        return grid;
    }
}