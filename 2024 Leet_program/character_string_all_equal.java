import java.util.HashMap;
import java.util.Map;

public class character_string_all_equal {
    public boolean makeEqual(String[] words) {
        int length = words.length;
        Map<Character, Integer> charCount = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
        }
        for (int count : charCount.values()) {
            if (count % length != 0) {
                return false;
            }
        }
        return true;
    }
}
