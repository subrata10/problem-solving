package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Problem Description:
 * Words that contain many consecutive consonants, like "schtschurowskia",
 * are generally considered somewhat hard to pronounce.
 *
 * We say that a word is hard to pronounce if it contains 4 or more consonants in a row;
 * otherwise it is easy to pronounce.
 * For example, "apple" and "polish" are easy to pronounce,
 * but "schtschurowskia" is hard to pronounce.
 *
 * You are given a string S consisting of
 * N lowercase Latin characters.
 * Determine whether it is easy to pronounce or not based on the rule above —
 * print YES if it is easy to pronounce and NO otherwise.
 *
 * For the purposes of this problem, the vowels are the characters
 * {a, e, i, o, u} and the consonants are the other 21 characters.
 */
public class WordPronounce {

    public static void main(String[] args) {
        InputStream stream = System.in;
        InputReader in = new InputReader(stream);

        int T = in.nextInt(); // read the number of test cases

        for(int t=0; t<T; t++) {
            int l = in.nextInt(); // read the length of the word
            String s = in.next(); // read the word

            int count = 0;
            String result = "";

            for(int i=0; i<l; i++) {
                char c = s.charAt(i);

                // if the character is not vowel then increased the counter by 1
                if(c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                    count++;

                    // the counter value will reach to 4 by consecutively it will break the loop
                    if(count >= 4) {
                        break;
                    }
                } else {
                    count = 0;
                }

            }

            if(count >= 4) {
                result = "NO";
            }
            else {
                result = "YES";
            }

            System.out.println(result);

        }
    }

    // code segment to read the input from user
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try{
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException ioe) {
                    throw new RuntimeException(ioe);
                }
            }

            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
