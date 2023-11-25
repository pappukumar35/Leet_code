public class Sum_of_Absolute_Differences_in_a_Sorted_Array {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int sz = nums.length;
        int[] result = new int[sz], prefSum = new int[sz];
        for (int indx = 0; indx < sz; indx++) {
            if (indx == 0)
                prefSum[indx] = nums[indx];
            else
                prefSum[indx] = prefSum[indx - 1] + nums[indx];
        }
        for (int indx = 0; indx < sz; indx++) {
            int currNum = nums[indx];
            int leftSum = currNum * (indx + 1) - prefSum[indx];
            int rightSum = (prefSum[sz - 1] - prefSum[indx] - (sz - 1 - indx) * currNum);
            result[indx] = leftSum + rightSum;
        }
        return result;
    }
}
