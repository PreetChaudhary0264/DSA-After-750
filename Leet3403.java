public class Leet3403 {
        public String answerString(String word, int numFriends) {
            int n = word.length();
            if(numFriends == 1)return word;
            int maxLengthPossible = n - (numFriends - 1);
            String res = "";

            char maxChar = 0;
            int maxCharIdx = 0;

            for (int i = 0; i <= n - 1; i++) {
                if (word.charAt(i) > maxChar) {
                    maxChar = word.charAt(i);
                    maxCharIdx = i;
                }
            }

            for (int i = maxCharIdx; i < n; i++) {
                int end = Math.min(i + maxLengthPossible, n);
                String curr = word.substring(i, end);
                if (res.compareTo(curr) < 0) {
                    res = curr;
                }
            }
                //this comment is for testing backend of RevAI
            return res;
        }
}
