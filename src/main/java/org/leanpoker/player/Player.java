package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Player {

    static final String VERSION = "1.0";

    public static int betRequest(JsonElement request) {
        JsonObject jsonObject = request.getAsJsonObject();
        JsonArray players = jsonObject.get("players").getAsJsonArray();
        JsonObject babyYoda = null;

        babyYoda = players.get(jsonObject.get("in_action").getAsInt()).getAsJsonObject();


        int currentBuyIn = jsonObject.get("current_buy_in").getAsInt();

        int round = jsonObject.get("round").getAsInt();
        int bet = babyYoda.get("bet").getAsInt();
        int current_buy_in = jsonObject.get("current_buy_in").getAsInt();
        int pot = jsonObject.get("pot").getAsInt();


        List<Card> communityCards = new ArrayList<>();
        List<Card> handCards = new ArrayList<>();
        List<Card> allCards = new ArrayList<>();
        Cards cards = new Cards();
        cards.setCommunityCards(communityCards);
        cards.setHoleCards(handCards);

        if (babyYoda != null) {
            JsonArray holeCards = babyYoda.get("hole_cards").getAsJsonArray();
            for (JsonElement card : holeCards) {
                String rank = card.getAsJsonObject().get("rank").getAsString();
                String suite = card.getAsJsonObject().get("suit").getAsString();
                allCards.add(new Card(rank, suite));
                handCards.add(new Card(rank, suite));
            }

            for (JsonElement communityCard : jsonObject.get("community_cards").getAsJsonArray()) {
                String rank = communityCard.getAsJsonObject().get("rank").getAsString();
                String suite = communityCard.getAsJsonObject().get("suit").getAsString();
                allCards.add(new Card(rank, suite));
                communityCards.add(new Card(rank, suite));
            }

            int call = current_buy_in - bet;
            int stack = babyYoda.get("stack").getAsInt();

            System.out.println("IS FLUSH : "+cards.isFlush());

            switch (communityCards.size()) {
                //első kör
                case 0: {
                    //pár
                    if (cards.isHolePair()) {
                        if (current_buy_in < 200) {
                            return call+200;
                        } else {
                            return call;
                        }
                    } else if (cards.getHoleCardsValue() > 15) {
                        if (current_buy_in < 600) {
                            return call;
                        }
                    } else if (cards.getHoleCardsValue() > 20){
                        return call;
                    }

                    else return 0;

                }

                case 3:

                case 4: {

                    if (cards.isDrill() || cards.isFlush()) {
                        return stack;
                    }

                    else if (cards.isHolePair()
                            || cards.isMixedPair()
                            || cards.isTwoPairs())
                    {
                        return call + 200;
                    } else {
                        if (current_buy_in < 500) {
                            return call;
                        } else {
                            return 0;
                        }
                    }


                    //TODO: if (cards.isPoker || cards.isStraight) { ALL IN }
                }

                case 5: {
                    if (current_buy_in < 200) {
                        return call;
                    } else return 0;
                }
            }
            if (current_buy_in < 200) {
                return current_buy_in;
            } else return 0;
        }
        return 0;
    }


    public static void main(String[] args) {
        String gameState = "{\n" +
                "  \"players\":[\n" +
                "    {\n" +
                "      \"name\":\"Player 1\",\n" +
                "     \"minimum_raise\": 240,\n" +
                "      \"stack\":1000,\n" +
                "      \"status\":\"active\",\n" +
                "      \"bet\":0,\n" +
                "      \"hole_cards\":[\n" +
                "                {\n" +
                "                    \"rank\": \"4\",\n" +
                "                    \"suit\": \"hearts\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"rank\": \"K\",\n" +
                "                    \"suit\": \"spades\"\n" +
                "                }\n" +
                "            ],\n" +
                "      \"version\":\"Version name 1\",\n" +
                "      \"id\":0\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\":\"Player 2\",\n" +
                "      \"stack\":1000,\n" +
                "      \"status\":\"active\",\n" +
                "      \"bet\":0,\n" +
                "      \"hole_cards\":[],\n" +
                "      \"version\":\"Version name 2\",\n" +
                "      \"id\":1\n" +
                "    }\n" +
                "  ],\n" +
                "      \"in_action\":0,\n" +
                "  \"tournament_id\":\"550d1d68cd7bd10003000003\",\n" +
                "  \"game_id\":\"550da1cb2d909006e90004b1\",\n" +
                "  \"round\":0,\n" +
                "  \"bet_index\":0,\n" +
                "  \"small_blind\":10,\n" +
                "  \"orbits\":0,\n" +
                "  \"dealer\":0,\n" +
                "  \"community_cards\":[\n" +
                "        {\n" +
                "            \"rank\": \"4\",\n" +
                "            \"suit\": \"spades\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"rank\": \"6\",\n" +
                "            \"suit\": \"hearts\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"rank\": \"6\",\n" +
                "            \"suit\": \"clubs\"\n" +
                "        }\n" +
                "    ],\n" +
                "  \"current_buy_in\":0,\n" +
                "  \"pot\":0\n" +
                "}";
        betRequest(new JsonParser().parse(gameState));
    }

    public static void showdown(JsonElement game) {
    }
}
