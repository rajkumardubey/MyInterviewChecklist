package self.learning.interview.coding;

import java.util.Scanner;

public class NumberProductUsingRecursion {
    /*
                            3*7
        findProduct(-3, 7)= 3 + 3 + 3 + 3 + 3 + 3 + 3
                          = 3 + findProduct(3, 6)
                          = 3 + 3 + findProduct(3, 5)
                          = 3 + 3 + 3 + findProduct(3, 4)
                          = 3 + 3 + 3 + 3 + findProduct(3, 3)
                          = 3 + 3 + 3 + 3 + 3 + findProduct(3, 2)
                          = 3 + 3 + 3 + 3 + 3 + 3 + findProduct(3, 1)
                          = 3 + 3 + 3 + 3 + 3 + 3 + 3 + findProduct(3, 0)
                          = 3 + 3 + 3 + 3 + 3 + 3 + 3 + 0 // Base Case: a*0 = 0
     */
    static int findProduct(int a, int b) {
        if (a == 0 || b == 0) return 0;

        /*
            case 1 : a > 0 and b < 0 [One negative number]
            swap the position of n and m to keep second parameter positive
        */
        if (a > 0 && b < 0)  return findProduct(b, a);

        /*
            case 2 : a < 0 and b < 0 [both negative number]
            return the product of their absolute values
        */
        if (a < 0 && b < 0)  return findProduct(Math.abs(a), Math.abs(b));

        /*
            As long as b is not 0 recursively call findProduct
            for a and b-1 return sum of a and the product of a times b-1
        */
        return a + findProduct(a, b - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();

        if (Math.abs(b) > Math.abs(a)) {
            System.out.println(findProduct(b, a));
        } else {
            System.out.println(findProduct(a, b));
        }
    }
}
