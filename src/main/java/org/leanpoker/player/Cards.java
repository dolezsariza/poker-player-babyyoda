package org.leanpoker.player;

import java.util.ArrayList;
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

    public boolean isCommunityPair() {
        for (Card card: communityCards) {
            if(card.rank == holeCards.get(0).rank || card.rank == holeCards.get(1).rank) {
                return true;
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

}
