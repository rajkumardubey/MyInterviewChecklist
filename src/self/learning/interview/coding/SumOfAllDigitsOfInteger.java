package self.learning.interview.coding;

import java.util.Scanner;

public class SumOfAllDigitsOfInteger {
    /*
        sumDigits(3655) = 3 + 6 + 5 + 5
                        = 5 + sumDigits(365)
                        = 5 + 5 + sumDigits(36)
                        = 5 + 5 + 6 + sumDigits(3)
                        = 5 + 5 + 6 + 3
                        = number%10 + sumDigits(number/10) where sumDigits(number) = number when `number < 10`
     */
    static int sumDigits(int number) {
        return number < 10 ? number : number % 10 + sumDigits(number / 10);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(sumDigits(input.nextInt()));
    }
}
