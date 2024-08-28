package Auguest;

import java.util.*;

public class Magic_Squares_In_Grid {
     private boolean isMagicSquare(int[][] grid, int i, int j) {
          // Check for distinct numbers from 1 to 9
          boolean[] seen = new boolean[10];
          for (int x = 0; x < 3; x++) {
               for (int y = 0; y < 3; y++) {
                    int num = grid[i + x][j + y];
                    if (num < 1 || num > 9 || seen[num])
                         return false;
                    seen[num] = true;
               }
          }

          int sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2]; // First row sum

          // Check rows
          for (int x = 0; x < 3; x++) {
               if (sum != grid[i + x][j] + grid[i + x][j + 1] + grid[i + x][j + 2])
                    return false;
          }

          // Check columns
          for (int y = 0; y < 3; y++) {
               if (sum != grid[i][j + y] + grid[i + 1][j + y] + grid[i + 2][j + y])
                    return false;
          }

          // Check diagonals
          if (sum != grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2])
               return false;
          if (sum != grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2])
               return false;

          return true;
     }

     public int numMagicSquaresInside(int[][] grid) {
          int count = 0;
          int rows = grid.length;
          int cols = grid[0].length;

          for (int i = 0; i <= rows - 3; i++) {
               for (int j = 0; j <= cols - 3; j++) {
                    if (isMagicSquare(grid, i, j)) {
                         count++;
                    }
               }
          }

          return count;
     }

     public static void main(String[] args) {

     }
}