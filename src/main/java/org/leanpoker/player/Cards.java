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
