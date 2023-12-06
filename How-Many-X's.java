class Solution {

    int countX(int L, int R, int X) {

        // code here

        // code here

        int count = 0;

        for (int a = L + 1; a < R; a++) {

            int temp = a; // Temporary variable to extract digits

            while (temp > 0) {

                int lastDigit = temp % 10; // found the last digit

                if (lastDigit == X) {

                    count++;

                }

                temp /= 10;// reduce the digit 2 digit tha to ek digit hoga

            }

        }

        return count;

    }

};