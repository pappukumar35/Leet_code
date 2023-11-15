import java.util.Arrays;

public class Maximum_Element_After_Decreasing_and_Rearranging {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int res = 1;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > res) {
                ++res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Maximum_Element_After_Decreasing_and_Rearranging solution = new Maximum_Element_After_Decreasing_and_Rearranging();

        // Example usage:
        int[] arr = { 2, 2, 1, 2, 1 };
        int result = solution.maximumElementAfterDecrementingAndRearranging(arr);
        System.out.println("The maximum element after decrementing and rearranging is: " + result);
    }
}
