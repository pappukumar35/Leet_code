class Solution {
    public int numberOfMatches(int n) {
        int count = 0;

        while (n > 1) {
            int x = n % 2;
            if ((n - x) % 2 == 0) {
                n = n / 2;
                count += n;
            }
            n += x;
        }
        return count;
    }
}