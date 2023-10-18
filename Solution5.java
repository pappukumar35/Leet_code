class Solution5 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        
        // Generate the Pascal's Triangle up to the rowIndex
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Calculate the value in the middle based on the values from the previous row.
                    List<Integer> prevRow = pascalTriangle.get(i - 1);
                    int value = prevRow.get(j - 1) + prevRow.get(j);
                    row.add(value);
                }
            }
            
            pascalTriangle.add(row);
        }
        
        // The result is the row at the given rowIndex.
        return pascalTriangle.get(rowIndex);
    }
}