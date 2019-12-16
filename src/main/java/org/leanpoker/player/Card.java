package org.leanpoker.player;

public class Card {
    int rank;
    String suit;

    Card(String rank, String suit){
        this.suit = suit;
        switch (rank){
            case "K":
                this.rank = 13;
                break;
            case "A":
                this.rank = 14;
                break;
            case "Q":
                this.rank = 12;
                break;
            case "J":
                this.rank = 11;
                break;
            default:
                this.rank = Integer.parseInt(rank);
        }
    }

    @Override
    public String toString() {
        return rank + suit;
    }
}
