package self.learning.interview.coding;

import java.util.*;

class Cards {
    int value;
    String suit;

    public void setCards(String suit, int r) {
        this.value = r;
        this.suit = suit;
    }

    //Write your code here.

    int getSuitPriority(String suitString) {
        switch (suitString.toLowerCase()) {
            case "spades":
                return 4;
            case "diamond":
                return 3;
            case "hearts":
                return 2;
            case "clubs":
                return 1;
        }
        return -1;
    }


}

class ClassicGame {
    int points1 = 0;
    int points2 = 0;

    public void game(Cards c1, Cards c2) {
        if (c1.value > c2.value) points1 = 1;
        else if (c1.value < c2.value) points2 = 1;
        else {
            if (c1.getSuitPriority(c1.suit) > c2.getSuitPriority(c2.suit)) points1 = 1;
            else if (c1.getSuitPriority(c1.suit) < c2.getSuitPriority(c2.suit)) points2 = 1;
            else {
                points1 = 1;
                points2 = 1;
            }
        }

        System.out.println("points of player 1 :" + " " + points1);
        System.out.println("points of player 2 :" + " " + points2);
    }

}

public class Source {

    public static void main(String[] args) {
        //Two objects (cards) of class Cards
        Cards c1 = new Cards();
        Cards c2 = new Cards();
        Scanner in = new Scanner(System.in);
        //Enter the suit of card 1
        String s1 = in.nextLine();
        c1.setCards(s1, in.nextInt());
        in.nextLine();
        //Enter the suit of card 2
        String s2 = in.nextLine();
        c2.setCards(s2, in.nextInt());
        ClassicGame c = new ClassicGame();

        c.game(c1, c2);
    }
}