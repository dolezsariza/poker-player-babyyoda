package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Map;
import java.util.Set;

public class Player {

    static final String VERSION = "1.0";

    public static int betRequest(JsonElement request) {
        JsonObject jsonObject = request.getAsJsonObject();
        JsonArray players = jsonObject.get("players").getAsJsonArray();
        JsonObject babyYoda;

        for (JsonElement player : players) {
            if(player.getAsJsonObject().get("name").equals("BabyYosa")) {
                babyYoda = player.getAsJsonObject();
            }
        }
        int currentBuyIn = jsonObject.get("current_buy_in").getAsInt();
        int pot  = jsonObject.get("pot").getAsInt();
        int minimumRaise  = jsonObject.get("minimum_raise").getAsInt();

        JsonArray holeCards = babyYoda.get("hole_cards").getAsJsonArray();


        return 500;
    }


    public static void main(String[] args) {
        String gameState = "{\n" +
                "  \"players\":[\n" +
                "    {\n" +
                "      \"name\":\"Player 1\",\n" +
                "      \"stack\":1000,\n" +
                "      \"status\":\"active\",\n" +
                "      \"bet\":0,\n" +
                "      \"hole_cards\":[],\n" +
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
                "  \"tournament_id\":\"550d1d68cd7bd10003000003\",\n" +
                "  \"game_id\":\"550da1cb2d909006e90004b1\",\n" +
                "  \"round\":0,\n" +
                "  \"bet_index\":0,\n" +
                "  \"small_blind\":10,\n" +
                "  \"orbits\":0,\n" +
                "  \"dealer\":0,\n" +
                "  \"community_cards\":[],\n" +
                "  \"current_buy_in\":0,\n" +
                "  \"pot\":0\n" +
                "}";
        betRequest(new JsonParser().parse(gameState));
    }

    public static void showdown(JsonElement game) {
    }
}
