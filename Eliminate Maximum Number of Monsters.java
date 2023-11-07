public class Eliminate
Maximum Number
of Monsters
{

    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double[] monstArrivalTime = new double[n];

        // Finding the arrival time of monster based on formula
        // (Time = Distance / Speed)
        for (int i = 0; i < n; i++) {
            monstArrivalTime[i] = ((double) (dist[i]) / (double) speed[i]);
        }

        // Sorting the arrival time of monster that helps in determining
        // the maximum monster to eliminate
        Arrays.sort(monstArrivalTime);
        int res = 0;
        double stick = 0.0;

        // Checking what monster arrive at what time and how much monster
        // I can eliminate
        for (int i = 0; i < n; i++) {
            if (stick < monstArrivalTime[i]) {
                res++;
                stick++;
            } else {
                break;
            }
        }
        return res;
    }
}}
