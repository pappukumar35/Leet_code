import java.util.Arrays;

public class Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        return Arrays.equals(ss, tt);
    }
}
