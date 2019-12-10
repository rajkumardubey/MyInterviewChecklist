package self.learning.interview.coding;

public class ReverseBits {
    public long reverse(long n) {
        for (long i = 0; i < 16; i++) n = swapBits(n, i, 32 - i - 1);
        return n;
    }

    private long swapBits(long n, long i, long j) {
        long a = (n >> i) & 1L;
        long b = (n >> j) & 1L;

        if ((a ^ b) != 0) n ^= (1L << i) | (1L << j);

        return n;
    }

    // Driver code
    public static void main(String[] args) {
        long n = 1L;
        System.out.println(new ReverseBits().reverse(n));
    }
}
