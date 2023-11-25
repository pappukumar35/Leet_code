class Minimize_Maximum_Pair_Sum_in_Array {
    public int minPairSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int hash[] = new int[100001];
        for (int num : nums) {
            hash[num]++;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int low = min;
        int high = max;
        max = Integer.MIN_VALUE;
        while (low <= high) {
            if (hash[low] == 0)
                low++;
            else if (hash[high] == 0)
                high--;
            else {
                max = Math.max(max, low + high);
                hash[low]--;
                hash[high]--;
            }
        }
        return max;
    }
}