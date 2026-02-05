package com.vehiculos;

import com.google.gson.Gson;

public class TestGson {
    public static void main(String[] args) {
        Gson g = new Gson();
        System.out.println(g.toJson("ok"));
    }
}
