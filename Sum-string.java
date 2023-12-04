class Solution {
    public String sumStrings(String s1, String s2) {
        int i = s1.length() - 1, j = s2.length() - 1;
        StringBuilder ans = new StringBuilder();
        int carry = 0;

        while (i >= 0 && j >= 0) {
            int x = Character.getNumericValue(s1.charAt(i));
            int y = Character.getNumericValue(s2.charAt(j));
            int res = x + y + carry;
            int rem = res % 10;
            carry = res / 10;
            ans.append(rem);
            i--;
            j--;
        }

        while (i >= 0) {
            int x = Character.getNumericValue(s1.charAt(i));
            int res = x + carry;
            int rem = res % 10;
            carry = res / 10;
            ans.append(rem);
            i--;
        }

        while (j >= 0) {
            int y = Character.getNumericValue(s2.charAt(j));
            int res = y + carry;
            int rem = res % 10;
            carry = res / 10;
            ans.append(rem);
            j--;
        }

        while (carry > 0) {
            int rem = carry % 10;
            ans.append(rem);
            carry /= 10;
        }

        return ans.reverse().toString();
    }

    public boolean solve(String s, int pos, int l1, int l2) {
        String s1 = s.substring(pos, pos + l1);
        String s2 = s.substring(pos + l1, pos + l1 + l2);
        String s3 = sumStrings(s1, s2);
        int n = s3.length();

        if (n > s.length() - pos - l1 - l2) {
            return false;
        }

        if (s.substring(pos + l1 + l2, pos + l1 + l2 + n).equals(s3)) {
            if (pos + l1 + l2 + n == s.length()) {
                return true;
            }
            return solve(s, pos + l1, l2, n);
        }

        return false;
        // @pankaj_meharchandai
    }

    public int isSumString(String s) {
        int n = s.length();
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (solve(s, 0, i, j)) {
                    return 1;
                }
            }
        }
        return 0;
    }
}