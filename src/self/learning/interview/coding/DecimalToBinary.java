package self.learning.interview.coding;

import java.util.Scanner;

public class DecimalToBinary {
    /*
        2| 17        Reminder
         |----          1
        2| 8
         |----          0
        2| 4
         |----          0
        2| 2
         |----          0
         | 1

        toBinary(17) = 1*10000 + 0*1000 + 0*100 + 0*10 + 1*1
                     = 17%2 + 10 * toBinary(8)
     */
    static int toBinary(int integer) {
        return integer == 0 ? 0 : (integer % 2 + 10 * toBinary(integer / 2));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(toBinary(input.nextInt()));
    }
}
