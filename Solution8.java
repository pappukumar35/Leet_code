class Solution8 {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (!sb1.isEmpty()) {
                    sb1.deleteCharAt(sb1.length() - 1);
                }
            } else {
                sb1.append(ch);
            }
        }

        for (char ch : t.toCharArray()) {
            if (ch == '#') {
                if (!sb2.isEmpty()) {
                    sb2.deleteCharAt(sb2.length() - 1);
                }
            } else {
                sb2.append(ch);
            }
        }

        return sb1.toString().equals(sb2.toString());
    }
}