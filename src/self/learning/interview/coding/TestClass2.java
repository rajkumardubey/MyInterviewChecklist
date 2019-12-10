package self.learning.interview.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TestClass2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            int N = Integer.parseInt(br.readLine().trim());
            String out_ = Solve(N);
            System.out.println(out_);
        }
        wr.close();
        br.close();
    }

    private static String Solve(int n) {
        StringBuilder result = new StringBuilder();
        while (n-- > 0) {
            int middle, position;
            middle = position = result.length() / 2;

            while (position < result.length() && result.charAt(position) != '4') {
                position++;
            }

            if (position < result.length()) {
                result.setCharAt(position, '5');
                result.setCharAt(middle - (position - middle) - 1, '5');
            } else {
                for (int i = 0; i < result.length(); i++) {
                    result.setCharAt(i, '4');
                }
                result = new StringBuilder("4" + result.toString() + "4");
                continue;
            }

            position--;
            while (position >= middle) {
                result.setCharAt(position, '4');
                result.setCharAt(middle - (position - middle) - 1, '4');
                position--;
            }
        }
        return result.toString();
    }
}
