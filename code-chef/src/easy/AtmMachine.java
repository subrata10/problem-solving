package easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AtmMachine {

    public static void main(String[] args) throws java.lang.Exception {
        InputStream stream = System.in;
        InputReader in = new InputReader(stream);

        int testcases = in.nextInt();

        for (int t = 0; t < testcases; t++) {
            int n = in.nextInt(); // number of people
            int k = in.nextInt(); // total money in atm

            StringBuilder sb = new StringBuilder();

            int[] money = new int[n];
            for (int i = 0; i < n; i++) {
                money[i] = in.nextInt();
            }

            for (int i = 0; i < n; i++) {
                if (money[i] <= k) {
                    sb.append("1");
                    k = k - money[i];
                } else {
                    sb.append("0");
                }
            }

            System.out.println(sb);

        }

    }

    static class InputReader {

        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }


        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
