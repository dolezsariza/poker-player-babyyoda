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

    public boolean isFlush(){

        if(holeCards.get(0).suit.equals(holeCards.get(1).suit)){
            int suits = 2;
            for(Card communityCard: communityCards){
                if(communityCard.suit.equals(holeCards.get(0).suit)){
                    suits++;
                }
            }
            if(suits == 5 || suits == 6)return true;
        }else {
            int suit1 = 1;
            for (Card communityCard : communityCards) {
                if (communityCard.suit.equals(holeCards.get(0).suit)) {
                    suit1++;
                }
            }
            if (suit1 == 5) return true;

            int suit2 = 1;
            for (Card communityCard : communityCards) {
                if (communityCard.suit.equals(holeCards.get(1).suit)) {
                    suit2++;
                }
            }
            if (suit2 == 5) return true;
        }return false;
    }

}
