package self.learning.interview.coding.questionbank.algorithm;

import java.util.Scanner;

public class Solution5 {
    /* Node of a linked list, Each node will represent a country name and address to next country */
    static class DataNode {
        String countryName;
        DataNode nextCountry;
    }

    /* Search of String India in the linked list */
    private static boolean isIndiaFound(DataNode firstCountry) {
        DataNode countryNow = firstCountry;

        while (countryNow != null) {
            if ("India".equalsIgnoreCase(countryNow.countryName)) return true;
            countryNow = countryNow.nextCountry;
        }
        return false;
    }

    public static void main(String[] args) {
        final Scanner consoleReader = new Scanner(System.in);

        final int countryCount = Integer.parseInt(consoleReader.nextLine());
        final DataNode head = new DataNode();

        DataNode temp = head;
        for (int index = 0; index < countryCount; index++) {
            temp.nextCountry = new DataNode();
            temp = temp.nextCountry;
            temp.countryName = consoleReader.nextLine();
        }

        if (isIndiaFound(head.nextCountry)) System.out.println("Will be able to catch");
        else System.out.println("Will not be able to catch");
    }
}

