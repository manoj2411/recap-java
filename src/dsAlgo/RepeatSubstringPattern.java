package dsAlgo;

public class RepeatSubstringPattern {

    public static void main(String[] args) {
        String[] inputs = { "abab", "aba", "abcabcabcabc"};

        for(String str : inputs) {
            System.out.println("S: " + str + "  Result: " + repeatedSubstringPattern(str));
        }
    }

    public static boolean repeatedSubstringPattern(String s) {

        for(int len = s.length() / 2; len > 0; len--) {
            if (s.length() % len == 0) {

                String pattern = s.substring(0, len);
                StringBuilder s2 = new StringBuilder();

                for (int times = 1; times <= s.length() / len; times++) {
                    s2.append(pattern);
                }
                if (s.equals(s2.toString()))
                    return true;
                // System.out.println("s: "+ s +"  patt: " + pattern + "  s2:" + s2);
            }
        }

        return false;
    }

}


