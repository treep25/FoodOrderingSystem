package com.food.system.demo.dish.cuisine;

public enum Cuisine {
    POLISH("Polish cuisine"),
    MEXICAN("Mexican cuisine"),
    ITALIAN("Italian cuisine");

    private final String value;

    Cuisine(String value) {
        this.value = value;
    }
}
