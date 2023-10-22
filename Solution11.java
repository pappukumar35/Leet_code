class Solution11 {
    public int maximumScore(int[] nums, int k) {

        int left = k - 1;
        int right = k + 1;
        int minvalue = nums[k];
        int maxscore = nums[k];
        int length = nums.length;

        while (left >= 0 || right < length) {
            if (left >= 0 && right < length && nums[left] >= nums[right]) {
                minvalue = Math.min(minvalue, nums[left]);
                maxscore = Math.max(maxscore, (right - left) * minvalue);
                left--;
            } else if (left >= 0 && right < length && nums[left] <= nums[right]) {
                minvalue = Math.min(minvalue, nums[right]);
                maxscore = Math.max(maxscore, (right - left) * minvalue);
                right++;
            } else if (left < 0) {
                minvalue = Math.min(minvalue, nums[right]);
                maxscore = Math.max(maxscore, (right - left) * minvalue);
                right++;
            } else {
                minvalue = Math.min(minvalue, nums[left]);
                maxscore = Math.max(maxscore, (right - left) * minvalue);
                left--;
            }
        }
        return maxscore;
    }
}