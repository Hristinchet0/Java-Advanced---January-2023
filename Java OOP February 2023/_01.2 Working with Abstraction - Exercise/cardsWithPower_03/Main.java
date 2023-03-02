package cardsWithPower_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CardRanks cardRank = CardRanks.valueOf(scanner.nextLine());
        CardSuits cardSuit = CardSuits.valueOf(scanner.nextLine());

        Card card = new Card(cardSuit, cardRank);
        System.out.printf("Card name: %s of %s; Card power: %d%n", cardRank, cardSuit, card.getPower());
    }
}
