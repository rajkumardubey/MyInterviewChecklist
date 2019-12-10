package self.learning.interview.coding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TestClass1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for (int t_i = 0; t_i < T; t_i++) {
            String[] arr_query1 = br.readLine().split(" ");
            int n = Integer.parseInt(arr_query1[0]);
            int k = Integer.parseInt(arr_query1[1]);
            String out_ = solve(k, n);
            System.out.println(out_);
        }
        wr.close();
        br.close();
    }

    static String solve(int k, int n) {
        // your code goes here

        if (k < n || 26 * n < k) return "";
        final StringBuilder result = new StringBuilder();
        int totalValue = 0;
        for (int index = 1; index <= n; index++) {
            for (int alphabetCounter = 26; alphabetCounter >= 1; alphabetCounter--) {
                if (k - (totalValue + alphabetCounter) >= n - index) {
                    totalValue += alphabetCounter;
                    result.append((char) (((int) 'a') + alphabetCounter - 1));
                    break;
                }
            }
        }
        return result.reverse().toString();
    }
}
