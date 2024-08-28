package Auguest;

import java.util.*;

public class Range_Sum_of_Sorted_Subarray_Sums {
     public int rangeSum(int[] nums, int n, int left, int right) {
          List<Integer> subarraySum = new ArrayList<>();

          // Calculating sum of subarrays
          for (int i = 0; i < nums.length; i++) {
               int sum = 0;
               for (int j = i; j < nums.length; j++) {
                    sum += nums[j];
                    subarraySum.add(sum);
               }
          }

          // Sort the subarray sums
          Collections.sort(subarraySum);

          // Return the result
          long result = 0;
          int mod = (int) (1e9 + 7);
          for (int i = left - 1; i < right; i++) {
               result = (result + subarraySum.get(i)) % mod;
          }
          return (int) result;
     }

     public static void main(String[] args) {

     }
}