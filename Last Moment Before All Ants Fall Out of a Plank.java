class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        // Initialize a variable to keep track of the maximum time
        int time = 0;

        // Iterate through the positions of ants moving to the left
        for (int pos : left) {
            // Update the maximum time if the current left-moving ant's position is greater
            // than the previously recorded maximum time
            time = Math.max(time, pos);
        }

        // Iterate through the positions of ants moving to the right
        for (int pos : right) {
            // Update the maximum time if the current right-moving ant's position (relative to
            // the right end of the plank) is greater than the previously recorded maximum time
            time = Math.max(time, n - pos);
        }

        // The final 'time' variable contains the maximum time, which is when the last ant(s)
        // fall off the plank, so return it as the result.
        return time;
    }

}