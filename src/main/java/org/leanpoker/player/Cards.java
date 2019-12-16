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


    public int getHoleCardsValue() {
        return this.holeCards.get(0).rank + this.holeCards.get(1).rank;
    }

    public boolean isHolePair() {
        return this.holeCards.get(0).rank == this.holeCards.get(1).rank;
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

}
