public class Find
the Winner
of an
Array Game
{

    public int getWinner(int[] arr, int k) {
        int winner = arr[0];
        int wins = 0;

        for (int i = 1; i < arr.length; i++) {
            if (winner > arr[i])
                wins++;
            else {
                wins = 1;
                winner = arr[i];
            }

            if (wins == k)
                break;
        }

        return winner;
    }
}}
