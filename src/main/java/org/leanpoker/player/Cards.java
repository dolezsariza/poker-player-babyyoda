package org.leanpoker.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cards {

    private List<Card> communityCards;
    private List<Card> holeCards;

    public List<Card> getCommunityCards() {
        return communityCards;
    }

    public void setCommunityCards(List<Card> communityCards) {
        this.communityCards = communityCards;
    }

    public List<Card> getHoleCards() {
        return holeCards;
    }

    public void setHoleCards(List<Card> holeCards) {
        this.holeCards = holeCards;
    }

    public boolean isHolePair() {
        return this.holeCards.get(0).rank == this.holeCards.get(1).rank;
    }

    public int getHoleCardsValue() {
        return this.holeCards.get(0).rank + this.holeCards.get(1).rank;
    }

    public boolean isMixedPair() {
        for (Card card: communityCards) {
            if(card.rank == holeCards.get(0).rank || card.rank == holeCards.get(1).rank) {
                return true;
            }
        }
        return false;
    }

    public boolean isCommunityPair() {

        for (int j = 0; j < communityCards.size()-1;j++) {
            for (int i = j + 1; i < communityCards.size(); i++) {
                if (communityCards.get(j) == communityCards.get(i)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isTwoPairs() {
        int numOfPairs = 0;
        for (Card card: communityCards) {
            if(card.rank == holeCards.get(0).rank) {
                numOfPairs++;
            }
            if(card.rank == holeCards.get(1).rank) {
                numOfPairs++;
            }
        }
        return numOfPairs == 2;
    }

    public boolean isDrill() {
        for (Card card: communityCards) {
            if(card.rank == holeCards.get(0).rank && card.rank == holeCards.get(1).rank) {
                return true;
            }
        }
        return false;
    }

    public boolean isFullHouse() {
        List<Card> cards = new ArrayList<>();
        boolean isDrill = false;
        cards.addAll(communityCards);
        cards.addAll(holeCards);
        List<Integer> values = new ArrayList<>();
        for (Card card: cards) {
            values.add(card.rank);
        }
        Collections.sort(values);
        for (int i = 0; i < values.size()-2; i++) {
            if (values.get(i) == values.get(i+1) && values.get(i) == values.get(i+2)) {
                isDrill = true;
                values.remove(values.get(i));
                values.remove(values.get(i));
                values.remove(values.get(i));
            }
        }
        if (isDrill) {
            for (int i = 0; i < values.size()-1; i++) {

                if (values.get(i) == values.get(i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

}
