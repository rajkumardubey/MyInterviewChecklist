package self.learning.interview.coding;

import java.util.Scanner;

public class RectangleOverlapping {
    static class Coordinates {
        int xCoordinates;
        int yCoordinates;
    }

    /*
        Two rectangles do not overlap if one of the following conditions is true.
            1) One rectangle is above top edge of other rectangle.
            2) One rectangle is on left side of left edge of other rectangle.
     */
    static boolean overlap(Coordinates topLeft1, Coordinates bottomRight1,
                           Coordinates topLeft2, Coordinates bottomRight2) {

        // If one rectangle is on left side of other
        if (topLeft1.xCoordinates > bottomRight2.xCoordinates || topLeft2.xCoordinates > bottomRight1.xCoordinates) {
            return false;
        }

        // If one rectangle is above other
        if (topLeft1.yCoordinates < bottomRight2.yCoordinates || topLeft2.yCoordinates < bottomRight1.yCoordinates) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Coordinates topLeft1 = new Coordinates();
        topLeft1.xCoordinates = input.nextInt();
        topLeft1.yCoordinates = input.nextInt();

        Coordinates bottomRight1 = new Coordinates();
        bottomRight1.xCoordinates = input.nextInt();
        bottomRight1.yCoordinates = input.nextInt();

        Coordinates topLeft2 = new Coordinates();
        topLeft2.xCoordinates = input.nextInt();
        topLeft2.yCoordinates = input.nextInt();

        Coordinates bottomRight2 = new Coordinates();
        bottomRight2.xCoordinates = input.nextInt();
        bottomRight2.yCoordinates = input.nextInt();

        System.out.println(overlap(topLeft1, bottomRight1, topLeft2, bottomRight2));
    }

}
