package org.leanpoker.player;

import com.google.gson.JsonElement;

import java.util.Map;

public class Player {

    static final String VERSION = "1.0";

    public static int betRequest(JsonElement request) {
        System.out.println(request.getAsString());
        return 0;
    }

    public static void showdown(JsonElement game) {
    }
}
