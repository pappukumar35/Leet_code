import java.util.ArrayList;

public class Array {

    int sumOfDependencies(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int count = 0;
        for (int i = 0; i < adj.size(); i++) {
            count += adj.get(i).size();
        }
        return count;
    }
};
