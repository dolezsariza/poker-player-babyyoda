package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;
import java.util.Set;

public class Player {

    static final String VERSION = "1.0";

    public static int betRequest(JsonElement request) {
        JsonObject obj = request.getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> entries = obj.entrySet();
        for (Map.Entry<String, JsonElement> entry: entries) {
            if(entry.getKey().equals("game_id")){
                System.err.println(entry.getKey());
            }
        }
        return 500;
    }

    public static void showdown(JsonElement game) {
    }
}
