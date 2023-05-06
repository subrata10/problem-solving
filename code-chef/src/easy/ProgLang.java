package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.codechef.com/problems/PROGLANG
 */
public class ProgLang {
    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        InputStream stream = System.in;
        InputReader in = new InputReader(stream);

        int testcase = in.nextInt();

        for (int i = 0; i < testcase; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int a1 = in.nextInt();
            int b1 = in.nextInt();
            int a2 = in.nextInt();
            int b2 = in.nextInt();

            if ((a == a1 && b == b1) || (a == b1 && b == a1)) {
                System.out.println(1);
            } else if ((a == a2 && b == b2) || (a == b2 && b == a2)) {
                System.out.println(2);
            } else {
                System.out.println(0);
            }
        }

    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer token;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            token = null;
        }

        public String next() {
            try {
                while (token == null || !token.hasMoreTokens()) {
                    token = new StringTokenizer(reader.readLine());
                }
            } catch (IOException ioe) {
                throw new RuntimeException(ioe);
            }

            return token.nextToken();

        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}
