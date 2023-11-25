public class Maximum_Number_of_Coins_You_Can_Get {
    public int maxCoins(int[] piles) {
        int max = 0;
        int n = piles.length;

        for (int i : piles) {
            if (max < i)
                max = i;
        }

        int[] freq = new int[max + 1];

        for (int i : piles) {
            freq[i]++;
        }

        int coins = 0;
        int chance = n / 3;

        int turn = 1;
        int i = max;

        while (chance != 0) {
            if (freq[i] > 0) {
                if (turn == 1)
                    turn = 0;
                else {
                    chance--;
                    turn = 1;
                    coins += i;
                }
                freq[i]--;
            } else {
                i--;
            }
        }

        return coins;
    }
}
