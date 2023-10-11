class Solution {
    public int minOperations(int[] nums) {
         int n = nums.length;
        int ans = n;
        
        HashSet<Integer> unique = new HashSet<>();
        for (int num : nums) {
            unique.add(num);
        }
        
        int[] newNums = new int[unique.size()];
        int index = 0;
        
        for (int num : unique) {
            newNums[index++] = num;
        }
            
        Arrays.sort(newNums);
        
        for (int i = 0; i < newNums.length; i++) {
            int left = newNums[i];
            int right = left + n - 1;
            int j = binarySearch(newNums, right);
            int count = j - i;
            ans = Math.min(ans, n - count);
        }
        
        return ans;
    }
    
    public int binarySearch(int[] newNums, int target) {
        int left = 0;
        int right = newNums.length;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (target < newNums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}