import java.util.Stack;

public class Leet2434 {
    public String robotWithString(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;

        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        char minChar = 'a';

        for (char c : s.toCharArray()) {
            st.push(c);
            freq[c - 'a']--;

            while (minChar <= 'z' && freq[minChar - 'a'] == 0)
                minChar++;

            while (!st.isEmpty() && st.peek() <= minChar)
                res.append(st.pop());
        }

        while (!st.isEmpty())
            res.append(st.pop());
//added comment foe testing
        return res.toString();
    }
}
