class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (count == target.length) {
                break;
            }
            list.add("Push");
            if (target[count++] != i) {
                list.add("Pop");
                count--;
            }
        }
        return list;
    }
}